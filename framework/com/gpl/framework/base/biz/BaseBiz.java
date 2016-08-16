package com.gpl.framework.base.biz;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.gpl.framework.base.dao.BaseDao;

public abstract class BaseBiz<T,PK extends Serializable> {
	
	public static final Logger logger = Logger.getLogger(BaseBiz.class);
	
	@Resource
	private BaseDao<T, Serializable> baseDao;
	
	public void init(BaseDao baseDao){
		this.baseDao = baseDao;
	}
	
	public T get(Serializable id){
		return baseDao.get(id);
	}
	
	public T load(Serializable id){
		return baseDao.load(id);
	}
	
	public List<T> getAll(String className){
		return baseDao.getAll(className);
	}
	
	public void deleteIds(String ids){
		String [] idArray = ids.split(",");
		for(String id : idArray){
			baseDao.delete(new Long(id));
		}
	}
	
	public void delete(Serializable id){
		baseDao.delete(id);
	}
	
	public void saveOrUpdate(T object){
		baseDao.saveOrUpdate(object);
	}
	
	public void update(T object){
		baseDao.update(object);
	}
	
	public PK save(T object){
		return (PK) baseDao.save(object);
	}
	
	public void saveOrUpdateAll(Collection<T> entities){
		baseDao.saveOrUpdateAll(entities);
	}
	
	public List<T> findByExample(T object){
		return baseDao.findByExample(object);
	}
	
	public T findUnique(final String hql,final Map<String, ?> values){
		return baseDao.findUnique(hql, values);
	}
	
	public T findUniqueByExample(T object){
		return baseDao.findUniqueByExample(object);
	}
	
	/**
	 * 查询分页页数
	 * @param sql
	 * @return
	 */
	public int sqlCount(final String sql){
		return baseDao.sqlCount(sql);
	}
	
	/**
	 * 执行hql进行批量修改/删除操作
	 * @param hql
	 * @param values
	 * @return
	 */
	public int batchExecute(final String hql,final Object... values){
		return baseDao.batchExecute(hql, values);
	}
	
	
	public int batchExecute(final String hql,final Map<String, ?> values){
		return baseDao.batchExecute(hql, values);
	}
	
	public <X> List<X> find(final String hql,final Map<String, ?> values){
		return baseDao.find(hql,values);
	}
	
	
}
