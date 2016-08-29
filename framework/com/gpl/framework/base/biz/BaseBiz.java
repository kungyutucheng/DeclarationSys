package com.gpl.framework.base.biz;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.gpl.framework.annotation.SystemBizLog;
import com.gpl.framework.base.dao.BaseDao;

public abstract class BaseBiz<T,PK extends Serializable> {
	
	public static final Logger logger = Logger.getLogger(BaseBiz.class);
	
	@Resource
	private BaseDao<T, Serializable> baseDao;
	
	public void init(BaseDao baseDao){
		this.baseDao = baseDao;
	}
	
	/**
	 * 根据id获取对应于className的数据
	 * @param id
	 * @param className
	 * @return
	 */
	@SystemBizLog(desc = "根据id获取对应于className的数据")
	public T get(Serializable id,String className){
		return baseDao.get(id,className);
	}
	
	/**
	 * 根据id获取对应于className的数据
	 * @param id
	 * @param className
	 * @return
	 */
	@SystemBizLog(desc = "根据id获取对应于className的数据")
	public T load(Serializable id){
		return baseDao.load(id);
	}
	
	/**
	 * 获取className下的全部数据
	 * @param className
	 * @return
	 */
	@SystemBizLog(desc = "获取className下的全部数据")
	public List<T> getAll(String className){
		return baseDao.getAll(className);
	}
	
	/**
	 * 批量删除数据
	 * @param ids
	 * @param className
	 */
	@SystemBizLog(desc = "批量删除数据")
	public void deleteIds(String ids,String className){
		String [] idArray = ids.split(",");
		for(String id : idArray){
			baseDao.delete(new Integer(id),className);
		}
	}
	
	/**
	 * 根据id删除单条数据
	 * @param id
	 * @param className
	 */
	@SystemBizLog(desc = "根据id删除单条数据")
	public void delete(Serializable id,String className){
		baseDao.delete(id,className);
	}
	
	/**
	 * 根据对象删除单条数据
	 * @param object
	 */
	@SystemBizLog(desc = "根据对象删除单条数据")
	public void delete(T object){
		baseDao.delete(object);
	}
	
	/**
	 * 保存或更新
	 * @param object
	 */
	@SystemBizLog(desc = "保存或更新")
	public void saveOrUpdate(T object){
		baseDao.saveOrUpdate(object);
	}
	
	/**
	 * 更新
	 * @param object
	 */
	@SystemBizLog(desc = "更新")
	public void update(T object){
		baseDao.update(object);
	}
	
	/**
	 * 保存
	 * @param object
	 * @return
	 */
	@SystemBizLog(desc = "保存")
	public PK save(T object){
		return (PK) baseDao.save(object);
	}
	
	/**
	 * 批量保存或更新
	 * @param entities
	 */
	@SystemBizLog(desc = "批量保存或更新")
	public void saveOrUpdateAll(Collection<T> entities){
		baseDao.saveOrUpdateAll(entities);
	}
	
	/**
	 * 根据对象寻找相似对象
	 * @param object
	 * @return
	 */
	@SystemBizLog(desc = "根据对象寻找相似对象")
	public List<T> findByExample(T object){
		return baseDao.findByExample(object);
	}
	
	/**
	 * 根据hql获取唯一对象
	 * @param hql
	 * @param values
	 * @return
	 */
	@SystemBizLog(desc = "根据hql获取唯一对象")
	public T findUnique(final String hql,final Map<String, ?> values){
		return baseDao.findUnique(hql, values);
	}
	
	/**
	 * 根据对象获取唯一相似对象
	 * @param object
	 * @return
	 */
	@SystemBizLog(desc = "根据对象获取唯一相似对象")
	public T findUniqueByExample(T object){
		return baseDao.findUniqueByExample(object);
	}
	
	/**
	 * 根据sql语句查询总数
	 * @param sql
	 * @return
	 */
	@SystemBizLog(desc = "根据sql语句查询总数")
	public int sqlCount(final String sql){
		return baseDao.sqlCount(sql);
	}
	
	/**
	 * 批量执行
	 * @param hql
	 * @param values
	 * @return
	 */
	@SystemBizLog(desc = "批量执行")
	public int batchExecute(final String hql,final Object... values){
		return baseDao.batchExecute(hql, values);
	}
	
	/**
	 * 批量执行
	 * @param hql
	 * @param values
	 * @return
	 */
	@SystemBizLog(desc = "批量执行")
	public int batchExecute(final String hql,final Map<String, ?> values){
		return baseDao.batchExecute(hql, values);
	}
	
	/**
	 * 批量执行
	 * @param hql
	 * @param values
	 * @return
	 */
	@SystemBizLog(desc = "批量执行")
	public <X> List<X> find(final String hql,final Map<String, ?> values){
		return baseDao.find(hql,values);
	}
	
	
}
