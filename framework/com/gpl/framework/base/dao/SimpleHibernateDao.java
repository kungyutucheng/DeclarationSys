package com.gpl.framework.base.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.metadata.ClassMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.util.Assert;
import org.springside.modules.utils.reflection.ReflectionUtils;

/**
 * 封装Hibernate原生API的DAO泛型基类
 * @author wyc
 *
 * @param <T> DAO操作的对象类型
 * @param <PK> 主键类型
 */
@SuppressWarnings("deprecation")
public class SimpleHibernateDao<T,PK extends Serializable> extends HibernateDaoSupport{

	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected Class<T> entityClass;
	
	/**
	 * 用于dao层子类使用的构造函数
	 * 通过子类的 泛型定义取得对象类型class
	 */
	public SimpleHibernateDao(){
		this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
	}
	
	/**
	 * 用于省略dao层，在service层直接使用通用simpleHIbernateDao的构造函数
	 * 在构造函数中定义对象类型class
	 * @param sessionFactory
	 * @param entityClass
	 */
	public SimpleHibernateDao(final SessionFactory sessionFactory , final Class<T> entityClass){
		super.setSessionFactory(sessionFactory);
		this.entityClass = entityClass;
	}
	
	@Autowired
	public void init(final SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
	
	/**
	 * hibernateTemplateDao 底层dao代码
	 * @param object
	 */
	@SuppressWarnings("deprecation")
	public void saveOrUpdate(T object){
		getHibernateTemplate().saveOrUpdate(object);
	}
	
	public void saveOrUpdateAll(Collection<T> entities){
		for(T entity : entities){
			this.saveOrUpdate(entity);
		}
	}
	
	public void update(T entity){
		getHibernateTemplate().update(entity);
	}
	
	public void merge(T entity){
		getHibernateTemplate().merge(entity);
	}
	
	/**
	 * 按对象查询数据
	 * @param entity
	 * @return
	 */
	public List<T> findByExample(T entity){
		return super.getHibernateTemplate().findByExample(entity);
	}
	
	public T load(PK id){
		return (T)super.getHibernateTemplate().load(entityClass, id);
	}
	
	/**
	 * 按对象查找唯一数据
	 * @param entity
	 * @return
	 */
	public T findUniqueByExample(T entity){
		List<T> rst = findByExample(entity);
		if(rst != null && !rst.isEmpty()){
			return rst.get(0);
		}
		return null;
 	}
	
	/**
	 * 保存新增或修改的对象
	 * @param entity
	 * @return
	 */
	public PK save(final T entity){
		return (PK) this.getHibernateTemplate().save(entity);
	}

	/**
	 * 独享必须是session中的对象或是含有id属性的transient对象
	 * @param entity
	 */
	public void delete(final T entity){
		this.getHibernateTemplate().delete(entity);
	}
	
	/**
	 * 按id删除对象
	 * @param id
	 */
	public void delete(final PK id){
		delete(get(id));
	}
	
	/**
	 * 按id获取对象
	 * @param id
	 * @return
	 */
	public T get(final PK id){
		return this.getHibernateTemplate().get(entityClass, id);
	}
	
	/**
	 * 获取全部对象
	 */
	public List<T> loadAll(){
		return this.getHibernateTemplate().loadAll(entityClass);
	}
	
	/**
	 * 根据参数查询数据
	 * @param hql 查询语句
	 * @param values 限制条件
	 * @return
	 */
	public List<T> find(final String hql,final Map<String, ?>... values){
		@SuppressWarnings("unchecked")
		List<T> list = (List<T>) getHibernateTemplate().executeFind(new HibernateCallback() {

			public Object doInHibernate(Session session) 
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if(values != null){
					query.setProperties(values);
				}
				List<T> list = query.list();
				return list;
			}
		});
		return list;
	}
	
	public <X> List<X> find(final String hql,final Object... values){
		@SuppressWarnings("unchecked")
		List<X> list = (List<X>) getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) 
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if(values != null){
					query.setProperties(values);
				}
				List<X> list = query.list();
				return list;
			}
		});
		return list;
	}
	
	public <X> List<X> find(final String hql){
		@SuppressWarnings("unchecked")
		List<X> list = (List<X>) getHibernateTemplate().executeFind(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session) 
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				List<X> list = query.list();
				return list;
			}
		});
		return list;
	}
	
	/**
	 * 按hql语句查询唯一对象
	 * 
	 * @param hql
	 * @param values 数量可变的参数，按顺序绑定
	 * @return
	 */
	public <X> X findUnique(final String hql,final Object... values){
		List<X> list = (List<X>) this.getHibernateTemplate().find(hql, values);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}
	
	public <X> X findUniqueByDetachedCriteria(DetachedCriteria detachedCriteria){
		List<X> list = (List<X>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		return (list != null && list.size() > 0) ? list.get(0) : null;
	}
	
	/**
	 * 执行hql进行批量修改/删除操作
	 * 
	 * @param hql
	 * @param values
	 * @return 更新记录数
	 */
	public int batchExecute(final String hql,final Map<String, ?> values){
		
		@SuppressWarnings("unchecked")
		Integer integer = (Integer) getHibernateTemplate().execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery(hql);
				if(values != null){
					query.setProperties(values);
				}
				return query.executeUpdate();
			}
		});
		return integer;
	}
	
	public int batchExecute(final String hql,final Object... values){
		return getHibernateTemplate().bulkUpdate(hql, values);
	}
	
	/**
	 * 初始化对象.
	 * 使用load()方法得到的仅是对象Proxy, 在传到View层前需要进行初始化.
	 * 如果传入entity, 则只初始化entity的直接属性,但不会初始化延迟加载的关联集合和属性.
	 * 如需初始化关联属性,需执行:
	 * Hibernate.initialize(user.getRoles())，初始化User的直接属性和关联集合.
	 * Hibernate.initialize(user.getDescription())，初始化User的直接属性和延迟加载的Description属性.
	 */
	public void initProxyObject(Object proxy){
		Hibernate.initialize(proxy);
	}
	
	/**
	 * 刷险当前session
	 */
	public void flush(){
		this.getHibernateTemplate().flush();
	}
	
	/**
	 * 为query添加distinct transformer
	 * 预加载关联对象的hql会引起主对象重复，需要进行distinct处理
	 */
	public Query distinct(Query query) {
		query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return query;
	}
	
	/**
	 * 为criteria添加distinct transformer
	 * 预加载关联对象会引起主对象重复，需进行distinct处理
	 */
	public Criteria distinct(Criteria criteria){
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria;
	}
	
	/**
	 * 取得对象的主键名
	 */
	public String getIdName(){
		ClassMetadata metadata = this.getHibernateTemplate().getSessionFactory().getClassMetadata(entityClass);
		return metadata.getIdentifierPropertyName();
	}
}
