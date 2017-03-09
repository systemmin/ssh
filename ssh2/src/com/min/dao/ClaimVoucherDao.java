package com.min.dao;

import com.min.entity.BizClaimVoucher;
import com.min.tools.pageSupport;

public interface ClaimVoucherDao extends BaseDao<BizClaimVoucher>{

	
	/**
	 * 分页
	 * @param criteria
	 * @param pageCurr
	 * @param pageSize
	 * @return
	 */
	public pageSupport<BizClaimVoucher> page( String hql, Integer currPageNo, Integer pageSize);
	
	
}
