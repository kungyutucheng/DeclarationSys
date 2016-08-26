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
 * ��װSpringSide��չ���ܵ�Hibernate Dao���ͻ���
 * 
 * ��չ���ܰ�����ҳ��ѯ�������Թ��������б��ѯ������Service��ֱ��ʹ�ã�Ҳ������չ����dao����ʹ��
 * @author wyc
 *
 * @param <T> dao�����Ķ�������
 * @param <PK> ��������
 */
@SuppressWarnings("deprecation")
public class HibernateDao <T,PK extends Serializable> extends SimpleHibernateDao<T, PK>{
	
	public static final Logger logger = Logger.getLogger(HibernateDao.class);
	
	/**
	 * ����dao������Ĺ��캯��ͨ������ķ��Ͷ���ȡ�ö�������CLass
	 */
	public HibernateDao(){
		super();
	}

	
	/**
	 * ����ʡ��dao�㣬service��ֱ��ʹ��ͨ�õ�hibernateDao�Ĺ��캯���ڹ��캯���ж����������
	 * @param sessionFactory
	 * @param entityClass
	 */
	public HibernateDao(final SessionFactory sessionFactory , final Class<T> entityClass){
		super(sessionFactory, entityClass);
	}

	//  --  ��ҳ��ѯ���� -- //
	
	public List<T> getAll(String className){
		String hql = " from " + className;
		return this.find(hql);
	}
	
	public Page<T> findPage(final Page<T> page,final String hql){
		@SuppressWarnings({ "unchecked" })
		List<T> list = (List<T>) getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) 
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				query.setMaxResults(page.getPageSize());
				query.setFirstResult(page.getPageSize() * (page.getPage() - 1));
				if(page.isAutoCount()){
					long totalCount = countHqlResult(hql);
					page.setTotal(totalCount);
				}
				return query.list();
			}
		});
		page.setRows(list);
		return page;
	}
	
	@SuppressWarnings("rawtypes")
	public Page<T> findPage(final Page<T> page,final String hql,final Object... values){
		@SuppressWarnings({ "unchecked" })
		List<T> list = (List<T>) getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) 
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if(values != null && values.length > 0){
					for(int i = 0;i < values.length ;i++){
						query.setParameter(i, values[i]);
					}
				}
				query.setMaxResults(page.getPageSize());
				query.setFirstResult(page.getPageSize() * (page.getPage() - 1));
				if(page.isAutoCount()){
					long totalCount = countHqlResult(hql, values);
					page.setTotal(totalCount);
				}
				return query.list();
			}
		});
		page.setRows(list);
		return page;
	}
	
	/**
	 * 
	 * @param page ��ҳ���
	 * @param object ��ѯ����
	 * @param orders ˳�����
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
				criteria.setMaxResults(page.getPage() * page.getPageSize());
				criteria.setFirstResult((page.getPage() - 1) * page.getPageSize());
				return criteria.list();
			}
		});
		page.setRows(list);
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
		
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria, (page.getPage() - 1) * page.getPageSize(), page.getPage() * page.getPageSize());
		if(page.isAutoCount()){
			long totalCount = getCountByCriteria(detachedCriteria);
			page.setTotal(totalCount);
		}
		page.setRows(list);
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
		
		List<T> list = (List<T>) getHibernateTemplate().findByCriteria(detachedCriteria, (page.getPage() - 1) * page.getPageSize(), page.getPage() * page.getPageSize());
		if(page.isAutoCount()){
			long totalCount = getCountByCriteria(detachedCriteria);
			page.setTotal(totalCount);
		}
		page.setRows(list);
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
				query.setFirstResult((page.getPage() - 1) * page.getPageSize());
				query.setMaxResults(page.getPageSize());
				List<T> list = query.list();
				if(page.isAutoCount()){
					long totalCount = countHqlResult(hql, page.getParams());
					page.setTotal(totalCount);
				}
				return list;
			}
		});
		page.setRows(list);
		return page;
	}
	
	/**
	 * �˴�ʹ��X����T��ԭ���ǣ����ʹ��T����ôֻ�ܰ�T����ʹ��X����԰�����������ͣ����ܾ���
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
					long totalCount = countHqlResult(hql);
					page.setTotal(totalCount);
				}
				
				return list;
			}
		});
		page.setRows(list);
		return page;
	}
	
	
	protected long countHqlResult(final String hql,final Object... values){
		String countHql = prepareCountHql(hql);
		try{
			Long count = findUnique(countHql, values);
			if(count == null){
				return 0l;
			}
			return count;
		}catch(Exception e){
			throw new RuntimeException("hql can't be auto counted,hql is " + hql,e); 
		}
	}
	
	protected long countHqlResult(final String hql){
		String countHql = prepareCountHql(hql);
		try{
			Long count = findUnique(countHql);
			if(count == null){
				return 0l;
			}
			return count;
		}catch(Exception e){
			throw new RuntimeException("hql can't be auto counted,hql is " + hql,e); 
		}
	}
	
	/**
	 * select�Ӿ���order by�Ӿ��Ӱ��count��ѯ,���м򵥵��ų�
	 * @param orgHql
	 * @return
	 */
	private String prepareCountHql(String orgHql){
		String fromHql = orgHql;
		fromHql = StringUtils.substring(fromHql, StringUtils.lastIndexOf(fromHql, "from"));
		fromHql = StringUtils.substringBefore(fromHql, "order by");
		System.out.println(fromHql);
		return "select count(*) " + fromHql;
	}
	
	
	private Criteria getCriteria(final Page<T> page,final Object object,Session session){
		Criteria criteria = session.createCriteria(entityClass);
		Example example = Example.create(criteria);
		//����ģ���ѯ
		example.enableLike(MatchMode.ANYWHERE);
		//��ֵ������ѯ
		example.excludeNone();
		//0������ѯ
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