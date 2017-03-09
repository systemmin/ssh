package com.min.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.biz.ClaimVoucherBiz;
import com.min.dao.ClaimVoucherDao;
import com.min.entity.BizClaimVoucher;
import com.min.tools.pageSupport;

@Service("claimvoucherBiz")
@Transactional
public class ClaimvoucherBizImpl implements ClaimVoucherBiz{

	private ClaimVoucherDao claimVoucherDao;
	@Autowired
	public void setClaimVoucherDao(ClaimVoucherDao claimVoucherDao) {
		this.claimVoucherDao = claimVoucherDao;
	}

	@Override
	public void save(BizClaimVoucher claimVoucher) {
		claimVoucherDao.saveOrUpdate(claimVoucher);
	}

	

	@Override
	public pageSupport<BizClaimVoucher> page(Map<String, Object> map,
			Integer currPageNo, Integer pageSize) {
		StringBuffer hql = new StringBuffer("from BizClaimVoucher where 1=1");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		if (map!=null) {
			if (map.get("struts") != null && !"".equals(map.get("struts"))) {
				hql.append("  and   status=" +" '"+map.get("struts")+"' ");
			}
			if (map.get("startDate") != null) {
				hql.append("  and  createTime>" + " ' "+ format.format(map.get("startDate"))+" ' ");
			}
			if (map.get("endDate") != null) {
				hql.append("  and   createTime<" +" ' "+  format.format(map.get("endDate"))+" ' ");
			}
		}
		if (currPageNo==null || currPageNo==0) {
			currPageNo=1;
		}
		if (pageSize==null || pageSize==0) {
			pageSize=5;
		}
		return claimVoucherDao.page(hql.toString(), currPageNo, pageSize);
	}

	@Override
	public BizClaimVoucher getQuery(BizClaimVoucher cl) {
		return claimVoucherDao.get(cl.getClass(), cl.getId());
	}

	

}
