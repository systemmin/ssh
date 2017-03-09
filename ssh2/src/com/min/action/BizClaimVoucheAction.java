package com.min.action;

import java.util.Date;
import java.util.List;

import com.min.biz.ClaimVoucherBiz;
import com.min.entity.BizClaimVoucher;
import com.min.entity.BizClaimVoucherDetail;
import com.min.entity.SysEmployee;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 添加报销单
 * 
 * @author Administrator
 * 
 */
public class BizClaimVoucheAction extends ActionSupport {

	private static final long serialVersionUID = -4859450600108392186L;
	// 报销单信息
	private BizClaimVoucher claimVoucher;// event、totalAccount、status
	// 报销单详细信息
	private BizClaimVoucherDetail claimVoucherDetail;
	// 报销单业务层对象
	private ClaimVoucherBiz claimvoucherBiz;

	private List<BizClaimVoucherDetail> bizClaimVoucherDetails;// item、account、desc

	// action请求方法
	public String addCvb() {
		
		try {
			for (BizClaimVoucherDetail detail : bizClaimVoucherDetails) {
				detail.setBizClaimVoucher(claimVoucher);
				claimVoucher.getBizClaimVoucherDetails().add(detail);
				
			}
			claimVoucher.setCreateTime(new Date());
			claimVoucher.setModifyTime(new Date());
			claimVoucher.setSysEmployeeByCreateSn((SysEmployee) ActionContext
					.getContext().getSession().get("employee"));
			claimVoucher.setSysEmployeeByNextDealSn(claimVoucher
					.getSysEmployeeByCreateSn());
			claimvoucherBiz.save(claimVoucher);
		} catch (Exception e) {
			
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	// 查询
	public String getQuery(){
		try {
			claimVoucher =claimvoucherBiz.getQuery(claimVoucher);
		
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}
	// 更新
	public String update(){
		try {
			claimVoucher =claimvoucherBiz.getQuery(claimVoucher);
		
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;

	}
	public BizClaimVoucher getClaimVoucher() {
		return claimVoucher;
	}

	public void setClaimVoucher(BizClaimVoucher claimVoucher) {
		this.claimVoucher = claimVoucher;
	}

	public BizClaimVoucherDetail getClaimVoucherDetail() {
		return claimVoucherDetail;
	}

	public void setClaimVoucherDetail(BizClaimVoucherDetail claimVoucherDetail) {
		this.claimVoucherDetail = claimVoucherDetail;
	}

	public ClaimVoucherBiz getClaimvoucherBiz() {
		return claimvoucherBiz;
	}

	public void setClaimvoucherBiz(ClaimVoucherBiz claimvoucherBiz) {
		this.claimvoucherBiz = claimvoucherBiz;
	}

	public List<BizClaimVoucherDetail> getBizClaimVoucherDetails() {
		return bizClaimVoucherDetails;
	}

	public void setBizClaimVoucherDetails(
			List<BizClaimVoucherDetail> bizClaimVoucherDetails) {
		this.bizClaimVoucherDetails = bizClaimVoucherDetails;
	}



	
}