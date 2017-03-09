package com.min.dao.imlp;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;
import com.min.dao.SysEmployeeDao;
import com.min.entity.SysEmployee;

@Repository
public class SysEmployeeDaoImpl extends BaseDaoImpl<SysEmployee> implements
		SysEmployeeDao {

	

/*	public void  show(int i , String... name){
		
		// 增删改
		this.getHibernateTemplate().bulkUpdate("?", 1,1,1);
		// 删除一个
		this.getHibernateTemplate().delete(null);
		// 删除多个
		this.getHibernateTemplate().deleteAll(new ArrayList());
		// 清除缓存
		this.getHibernateTemplate().clear();
		// 清除某一个对象的
		this.getHibernateTemplate().evict(null);
		// 查询需要传入hql语句
		this.getHibernateTemplate().find("form hh ?","sss",new Date());
		// 分页查询
		this.getHibernateTemplate().findByCriteria(null, 1, 2);
		// 查询动态查询那个元素有值就动态生成查询语句obj（主键外键不能作为条件查询、条件运算=和limke）
		this.getHibernateTemplate().findByExample("obj");
		// 命名查询
		this.getHibernateTemplate().findByNamedQuery("");
		// :name站位符查询、站位符数组、对应得值数组
		this.getHibernateTemplate().findByNamedParam("from nam=:name", new String[], new String[]);
		// 立即执行
		this.getHibernateTemplate().flush();
		// 
		this.getHibernateTemplate().iterate("");
		//
		this.getHibernateTemplate().merge(entityName, entity);
		}*/
	// 模板回调
	public List<SysEmployee> get(final int age,final int page){
		return  this.getHibernateTemplate().execute(new HibernateCallback<List<SysEmployee>>() {

			@SuppressWarnings("unchecked")
			@Override
			public List<SysEmployee> doInHibernate(Session arg0)
					throws HibernateException, SQLException {
				return arg0.createQuery("from se")
						.setFirstResult(page)
						.setMaxResults(age)
						.list();
			}
		});
	}
}
