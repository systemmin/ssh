package com.min.dao;

import java.util.Collection;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.min.tools.pageSupport;

public interface BaseDao<T> {

	/**
	 * 保存数据
	 * @param entity
	 */
	public void save(T entity);
	
	/**
	 * 根据id获得一个对象
	 * @param cl
	 * @param id
	 * @return
	 */
	public T get(Class<?> cl,java.io.Serializable id);
	
	/**
	 * 更新数据
	 * @param entity
	 */
	public void update(T entity);
	
	/**
	 * 删除
	 * @param entity
	 */
	public void delete(T entity);
	
	/**
	 * 删除多个
	 * @param entity
	 */
	public void deleteAll(Collection<T> entity);
	
	/**
	 * 保存或更新
	 * @param entity
	 */
	public void saveOrUpdate(T entity);
	
	/**
	 * 
	 * @param entity
	 * @return
	 */
	public T merge(T entity);
	
	/**
	 * DetachedCriteria接口
	 * @param criteria
	 * @return
	 */
	public List<T> findByCriteria(DetachedCriteria criteria);
	
	/**
	 * 分页
	 * @param criteria条件
	 * @param pageNo当前页
	 * @param pageSize页面容量
	 * @return List集合对象
	 */
	public List<T> findByPage(DetachedCriteria criteria,int pageNo,int pageSize);
	
	/**
	 * 查询总记录数
	 * @param criteria
	 * @return
	 */
	public Integer getRowCount(Class<T> entity);
	
	/**
	 * 
	 * @param exmpleEntity
	 * @return
	 */
	public List<T> findByExmple(T exmpleEntity);
	
	/**
	 * 查询
	 * @param hql 语句
	 * @param objects参数
	 * @return
	 */
	public List<T> find(String hql,Object...objects);
	
	/**
	 * 分页
	 * @param hql语句
	 * @param page对象
	 * @return page对象进行数据分装
	 */
	public pageSupport<T> page( String hql, pageSupport<T> page);
	
	/**
	 * 查询所有数据
	 * @param c1
	 * @return
	 */
	public List<T> findAll(Class<T> c1);
	
}
