package com.gpl.framework.base.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.security.config.http.MatcherType;
import org.springside.modules.orm.PropertyFilter.MatchType;
import org.springside.modules.utils.reflection.ReflectionUtils;

import com.gpl.framework.util.Page;



/**
 * 封装SpringSide扩展功能的Hibernate Dao泛型基类
 * 
 * 扩展功能包括分页查询，按属性过滤条件列表查询，可在Service层直接使用，也可以扩展泛型dao子类使用
 * @author wyc
 *
 * @param <T> dao操作的对象类型
 * @param <PK> 主键类型
 */
@SuppressWarnings("deprecation")
public class HibernateDao <T,PK extends Serializable> extends SimpleHibernateDao<T, PK>{
	
	public static final Logger logger = Logger.getLogger(HibernateDao.class);
	
	/**
	 * 用于dao层子类的构造函数，通过子类的泛型定义取得对象类型CLass
	 */
	public HibernateDao(){
		super();
	}

	
	/**
	 * 用于省略dao层，service层直接使用通用的hibernateDao的构造函数，在构造函数中定义对象类型
	 * @param sessionFactory
	 * @param entityClass
	 */
	public HibernateDao(final SessionFactory sessionFactory , final Class<T> entityClass){
		super(sessionFactory, entityClass);
	}

	//  --  分页查询函数 -- //
	
	public List<T> getAll(){
		String hql = " from " + entityClass.getName();
		return this.find(hql);
	}
	
	@SuppressWarnings("rawtypes")
	public Page<T> findPage(final Page<T> page,final String hql,final Object... values){
		@SuppressWarnings({ "unchecked" })
		List<T> list = (List<T>) getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) 
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if(values != null){
					query.setProperties(values);
				}
				query.setMaxResults(page.getPageSize());
				query.setFirstResult(page.getPageSize() * (page.getPageNo() - 1));
				if(page.isAutoCount()){
					long totalCount = countHqlResult(hql, values);
					page.setTotalCount(totalCount);
				}
				return query.list();
			}
		});
		page.setResult(list);
		return page;
	}
	
	/**
	 * 
	 * @param page 分页数据
	 * @param object 查询参数
	 * @param orders 顺序参数
	 * @return
	 */
	public Page<T> findPage(final Page<T> page ,final Object object,final String[] orders){
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) 
					throws HibernateException, SQLException {
				Criteria criteria = getCriteria(page, object, session);
				if(orders != null){
					for(String order : orders){
						criteria.addOrder(Order.desc(order));
					}
				}
				criteria.setMaxResults(page.getPageNo() * page.getPageSize());
				criteria.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
				return criteria.list();
			}
		});
		page.setResult(list);
		return page;
	}
	
	
	public Page<T> findByPage(final Page<T> page,final String[] orders,final boolean desc,DetachedCriteria detachedCriteria){
		for(String order : orders){
			if(desc){
				detachedCriteria.addOrder(Order.desc(order));
			}else{
				detachedCriteria.addOrder(Order.asc(order));
			}
		}
		
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria, (page.getPageNo() - 1) * page.getPageSize(), page.getPageNo() * page.getPageSize());
		if(page.isAutoCount()){
			long totalCount = getCountByCriteria(detachedCriteria);
			page.setTotalCount(totalCount);
		}
		page.setResult(list);
		return page;
	}
	
	public Page<T> findByPage(final Page<T> page,final Map<String, String> orderMap,DetachedCriteria detachedCriteria){
		if(orderMap != null && orderMap.size() > 0){
			for(Map.Entry<String, String> entry : orderMap.entrySet()){
				String orderby = entry.getKey();
				String order = entry.getValue();
				String [] orderArr = null;
				if(StringUtils.isNotBlank(order)){
					orderArr = order.split(",");
				}
				if("asc".equalsIgnoreCase(orderby)){
					for(int i = 0;orderArr != null && i < orderArr.length; i++){
						detachedCriteria.addOrder(Order.asc(StringUtils.trim(orderArr[i])));
					}
				}else if("desc".equalsIgnoreCase(orderby)){
					for(int i = 0;orderArr != null && i < orderArr.length; i++){
						detachedCriteria.addOrder(Order.desc(StringUtils.trim(orderArr[i])));
					}
				}
			}
		}
		
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria, (page.getPageNo() - 1) * page.getPageSize(), page.getPageNo() * page.getPageSize());
		if(page.isAutoCount()){
			long totalCount = getCountByCriteria(detachedCriteria);
			page.setTotalCount(totalCount);
		}
		page.setResult(list);
		return page;
	}
	
	public List<T> findByDetachedCriteria(final DetachedCriteria detachedCriteria){
		@SuppressWarnings("unchecked")
		List<T> list = getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(session);
				return criteria.list();
			}
		});
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public Page<T> findPage(final Page<T> page,final Class<T> clss){
		List<T> list = (List<T>) getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				String hql = "from " + clss.getName() + "where 1=1";
				Query query = session.createQuery(hql);
				query.setFirstResult((page.getPageNo() - 1) * page.getPageSize());
				query.setMaxResults(page.getPageSize());
				List<T> list = query.list();
				if(page.isAutoCount()){
					long totalCount = countHqlResult(hql, page.getParams());
					page.setTotalCount(totalCount);
				}
				return list;
			}
		});
		page.setResult(list);
		return page;
	}
	
	/**
	 * 此处使用X而不是T的原因是：如果使用T，那么只能绑定T，而使用X则可以绑定其他数据类型，不受局限
	 * @param hql
	 * @param values
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <X> List<X> find(final String hql,final Map<String, ?> values){
		List<X> list = (List<X>) getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if(values != null){
					query.setProperties(values);
				}
				
				return query.list();
			}
		});
		return list;
	}
	
	public <X> List<X> find(final String hql){
		@SuppressWarnings("unchecked")
		List<X> list = (List<X>) getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				try{
				Query query = session.createQuery(hql);
				return query.list();
				}catch(Exception e){
					e.printStackTrace();
					return null;
				}
			}
		});
		return list;
	}
	
	public <X> X findUnique(final String hql,final Map<String, ?> values){
		List<X> list = find(hql,values);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public Page<T> findPage(final Page<T> page,final String hql,
			final Map<String, ?> values){
		List<T> list = (List<T>) getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setFirstResult(page.getFirstInPage() - 1);
				query.setMaxResults(page.getPageSize());
				List<T> list = query.list();
				if(page.isAutoCount()){
					long totalCount = countHqlResult(hql, values);
					page.setTotalCount(totalCount);
				}
				return list;
			}
		});
		page.setResult(list);
		return page;
	}
	
	
	protected long countHqlResult(final String hql,final Object... values){
		String countHql = prepareCountHql(hql);
		try{
			Long count = findUnique(hql, values);
			if(count == null){
				return 0l;
			}
			return count;
		}catch(Exception e){
			throw new RuntimeException("hql can't be auto counted,hql is " + hql,e); 
		}
	}
	
	/**
	 * select子句与order by子句会影响count查询,进行简单的排除
	 * @param orgHql
	 * @return
	 */
	private String prepareCountHql(String orgHql){
		String fromHql = orgHql;
		fromHql = "from " + StringUtils.substringAfter(fromHql, "from");
		fromHql = StringUtils.substringBefore(fromHql, "order by");
		return "select count(*) " + fromHql;
	}
	
	
	private Criteria getCriteria(final Page<T> page,final Object object,Session session){
		Criteria criteria = session.createCriteria(entityClass);
		Example example = Example.create(criteria);
		//开启模糊查询
		example.enableLike(MatchMode.ANYWHERE);
		//空值不做查询
		example.excludeNone();
		//0不做查询
		example.excludeZeroes();
		criteria.add(example);
		return criteria;
	}

	public int getCountByCriteria(final DetachedCriteria detachedCriteria){
		@SuppressWarnings("unchecked")
		Long count = getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session arg0) throws HibernateException, SQLException {
				Criteria criteria = detachedCriteria.getExecutableCriteria(arg0);
				criteria.setFirstResult(0);
				
				return criteria.setProjection(Projections.rowCount());
			}
			
		});
		if(count == null){
			return 0;
		}
		return count.intValue();
	}
	

}