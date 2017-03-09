package com.min.dao.imlp;

import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import com.min.dao.ClaimVoucherDao;
import com.min.entity.BizClaimVoucher;
import com.min.tools.pageSupport;

@Repository
public class ClaimVoucherDaoImpl extends BaseDaoImpl<BizClaimVoucher> implements
		ClaimVoucherDao {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public pageSupport<BizClaimVoucher> page(final String hql,final Integer currPageNo ,final Integer pageSize) {
		pageSupport<BizClaimVoucher> pageSupport = new pageSupport<BizClaimVoucher>();
		pageSupport.setTotalCount(this.getRowCount(BizClaimVoucher.class));
		pageSupport.setCurrPageNo(currPageNo);
		pageSupport.setItme(this.getHibernateTemplate().executeFind(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session arg0)
						throws HibernateException, SQLException {
					return arg0.createQuery(hql)
							.setFirstResult((currPageNo-1)*pageSize)
							.setMaxResults(pageSize)
							.list();
				}
			}));
		return pageSupport;
	}


}
