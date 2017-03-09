package com.min.biz;

import java.util.Map;

import com.min.entity.BizClaimVoucher;
import com.min.tools.pageSupport;

public interface ClaimVoucherBiz {

	/**
	 * 保存报销单
	 * @param bizClaimVoucher
	 */
	public void save(BizClaimVoucher bizClaimVoucher);
	
	
	public pageSupport<BizClaimVoucher> page(Map<String, Object> map,Integer currPageNo,Integer pageSize);
	
	
	public BizClaimVoucher getQuery(BizClaimVoucher bizClaimVoucher);
}
