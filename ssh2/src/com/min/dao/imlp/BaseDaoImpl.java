package com.min.dao.imlp;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.min.dao.BaseDao;
import com.min.tools.pageSupport;

public class BaseDaoImpl<T> implements BaseDao<T>{

	private Class<T> clazz; //子类指定的泛型的类型	
	
	/*public BaseDaoImpl(){
		//通过反射机制获取子类传递过来的实体类的类型信息
		ParameterizedType type=(ParameterizedType)this.getClass().getGenericSuperclass();
		this.clazz=(Class<T>)type.getActualTypeArguments()[0];
		
	}*/
	
	private HibernateTemplate hibernateTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Autowired()
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}	

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public T get(Class cl, Serializable id) {
		return (T) this.getHibernateTemplate().get(cl, id);
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void deleteAll(Collection<T> entity) {
		this.getHibernateTemplate().deleteAll(entity);
	}

	@Override
	public void saveOrUpdate(T entity) {
		this.getHibernateTemplate().saveOrUpdate(entity);
	}

	@Override
	public T merge(T entity) {
		return this.getHibernateTemplate().merge(entity);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByCriteria(DetachedCriteria criteria) {
		return this.getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByPage(DetachedCriteria criteria, int pageNo,
			int pageSize) {
		return this.getHibernateTemplate().findByCriteria(criteria, pageNo, pageSize);
	}

	@Override
	public Integer getRowCount(Class<T> entity) {
		DetachedCriteria criteria= DetachedCriteria.forClass(entity);
		criteria.setProjection(Projections.rowCount());
		return (Integer) this.getHibernateTemplate().findByCriteria(criteria).get(0);
		
		/*this.getHibernateTemplate().execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				session.createCriteria(Class<T>).setProjection(Projections.rowCount()).uniqueResult();
				return null;
			}});*/
	}

	@Override
	public List<T> findByExmple(T exmpleEntity) {
		return null;
	}

	@Override
	public List<T> find(String hql, Object... objects) {
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public pageSupport<T> page(final String hql,final pageSupport<T> page) {
		pageSupport<T> pageSupport = new pageSupport<T>();
		pageSupport.setTotalCount(this.getRowCount(clazz));
		pageSupport.setItme(this.getHibernateTemplate().executeFind(new HibernateCallback<List<T>>() {
				@Override
				public List<T> doInHibernate(Session arg0)
						throws HibernateException, SQLException {
					return (List<T>) arg0.createQuery(hql)
							.setFirstResult((page.getCurrPageNo()-1)*page.getPageSize())
							.setMaxResults(page.getPageSize())
							.list();
				}
			}));
		return  pageSupport;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Class<T> c1) {
		
		return this.getHibernateTemplate().findByCriteria(DetachedCriteria.forClass(clazz));
	}

}
