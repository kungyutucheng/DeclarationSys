package com.gpl.framework.base.dao;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Component;



@Component
@Scope(value = "prototype")
public class BaseDao<T, PK extends Serializable> extends HibernateDao<T, PK> {
	
	public static final Logger logger = Logger.getLogger(BaseDao.class);
	
	@Autowired
	private BaseJdbcDao baseJdbcDao;
	
	public BaseJdbcDao getBaseJdbcDao(){
		return baseJdbcDao;
	}
	
	public void setBaseJdbcDao(BaseJdbcDao baseJdbcDao){
		this.baseJdbcDao = baseJdbcDao;
	}

	/*@Autowired
	protected SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public T save(T t){
		Session session = null;
		Transaction transaction = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			return t;
		}catch(Exception e){
			e.printStackTrace();
			if(transaction != null)
			transaction.rollback();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return null;
	}
	
	
	public boolean update(T t){
		Session session = null;
		Transaction transaction = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(t);
			transaction.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			if(transaction != null){
				transaction.rollback();
			}
		}finally{
			if(session != null)
			session.close();
		}
		return false;
	}
	
	
	public boolean delete(T t){
		Session session = null;
		Transaction transaction = null;
		try{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.delete(t);
			transaction.commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			if(transaction != null){
				transaction.rollback();
			}
		}finally{
			if(session != null){
				session.close();
			}
		}
		return false;
	}
	
	public List<T> findPage(Page<T> page,String sql){
		Session session = null;
		try{
			session = sessionFactory.openSession();
			Query query = session.createQuery(sql);
			query.setFirstResult(page.getPageNo() * page.getPageSize());
			query.setMaxResults(page.getPageNo() * page.getPageSize() + page.getPageSize());
			return query.list();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(session != null){
				session.close();
			}
		}
		return null;
	}
	*/

	/**
	 * ²éÑ¯·ÖÒ³Ò³Êý
	 * @param sql
	 * @return
	 */
	public int sqlCount(final String sql){
		final String resultSql = "select count(*) from (" + sql + ") as countsql";
		try{
			BigInteger totalDecimal = (BigInteger) getSessionFactory().getCurrentSession().createSQLQuery(resultSql).uniqueResult();
			return totalDecimal.intValue();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int sequence(String seqName){
		final String resultSql = "Select nextval('" + seqName + "') as seq";
		try{
			BigInteger totalDecimal = (BigInteger) getSessionFactory().getCurrentSession().createSQLQuery(resultSql).uniqueResult();
			return totalDecimal.intValue();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	
	public int sequence(){
		final String resultSql = "select nextval('hibernate_sequence') as seq";
		try{
			BigInteger totalDecimal = (BigInteger) getSessionFactory().getCurrentSession().createQuery(resultSql).uniqueResult();
			return totalDecimal.intValue();
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
}