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
 * ��װHibernateԭ��API��DAO���ͻ���
 * @author wyc
 *
 * @param <T> DAO�����Ķ�������
 * @param <PK> ��������
 */
@SuppressWarnings("deprecation")
public class SimpleHibernateDao<T,PK extends Serializable> extends HibernateDaoSupport{

	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected Class<T> entityClass;
	
	/**
	 * ����dao������ʹ�õĹ��캯��
	 * ͨ������� ���Ͷ���ȡ�ö�������class
	 */
	public SimpleHibernateDao(){
		this.entityClass = ReflectionUtils.getSuperClassGenricType(getClass());
	}
	
	/**
	 * ����ʡ��dao�㣬��service��ֱ��ʹ��ͨ��simpleHIbernateDao�Ĺ��캯��
	 * �ڹ��캯���ж����������class
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
	 * hibernateTemplateDao �ײ�dao����
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
	 * �������ѯ����
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
	 * ���������Ψһ����
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
	 * �����������޸ĵĶ���
	 * @param entity
	 * @return
	 */
	public PK save(final T entity){
		return (PK) this.getHibernateTemplate().save(entity);
	}

	/**
	 * ���������session�еĶ�����Ǻ���id���Ե�transient����
	 * @param entity
	 */
	public void delete(final T entity){
		this.getHibernateTemplate().delete(entity);
	}
	
	/**
	 * ��idɾ������
	 * @param id
	 */
	public void delete(final PK id){
		delete(get(id));
	}
	
	/**
	 * ��id��ȡ����
	 * @param id
	 * @return
	 */
	public T get(final PK id){
		return this.getHibernateTemplate().get(entityClass, id);
	}
	
	/**
	 * ��ȡȫ������
	 */
	public List<T> loadAll(){
		return this.getHibernateTemplate().loadAll(entityClass);
	}
	
	/**
	 * ���ݲ�����ѯ����
	 * @param hql ��ѯ���
	 * @param values ��������
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
	 * ��hql����ѯΨһ����
	 * 
	 * @param hql
	 * @param values �����ɱ�Ĳ�������˳���
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
	 * ִ��hql���������޸�/ɾ������
	 * 
	 * @param hql
	 * @param values
	 * @return ���¼�¼��
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
	 * ��ʼ������.
	 * ʹ��load()�����õ��Ľ��Ƕ���Proxy, �ڴ���View��ǰ��Ҫ���г�ʼ��.
	 * �������entity, ��ֻ��ʼ��entity��ֱ������,�������ʼ���ӳټ��صĹ������Ϻ�����.
	 * �����ʼ����������,��ִ��:
	 * Hibernate.initialize(user.getRoles())����ʼ��User��ֱ�����Ժ͹�������.
	 * Hibernate.initialize(user.getDescription())����ʼ��User��ֱ�����Ժ��ӳټ��ص�Description����.
	 */
	public void initProxyObject(Object proxy){
		Hibernate.initialize(proxy);
	}
	
	/**
	 * ˢ�յ�ǰsession
	 */
	public void flush(){
		this.getHibernateTemplate().flush();
	}
	
	/**
	 * Ϊquery���distinct transformer
	 * Ԥ���ع��������hql�������������ظ�����Ҫ����distinct����
	 */
	public Query distinct(Query query) {
		query.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return query;
	}
	
	/**
	 * Ϊcriteria���distinct transformer
	 * Ԥ���ع�������������������ظ��������distinct����
	 */
	public Criteria distinct(Criteria criteria){
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria;
	}
	
	/**
	 * ȡ�ö����������
	 */
	public String getIdName(){
		ClassMetadata metadata = this.getHibernateTemplate().getSessionFactory().getClassMetadata(entityClass);
		return metadata.getIdentifierPropertyName();
	}
}
