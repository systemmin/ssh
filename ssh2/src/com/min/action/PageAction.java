package com.min.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.min.biz.ClaimVoucherBiz;
import com.min.entity.BizClaimVoucher;
import com.min.tools.pageSupport;
import com.opensymphony.xwork2.ActionSupport;

public class PageAction extends ActionSupport {

	private static final long serialVersionUID = 8599138848874025662L;
	// 业务层实现类
	private ClaimVoucherBiz claimvoucherBiz;
	// 开始时间
	private Date startDate;
	// 结束时间
	private Date endDate;
	// 分页类
	private String struts;
	private Integer currPageNo;
	private Integer pageSize;

	private pageSupport<BizClaimVoucher> pageSupport ;
	public Integer getCurrPageNo() {
		return currPageNo;
	}

	public void setCurrPageNo(Integer currPageNo) {
		this.currPageNo = currPageNo;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String execute() throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		 pageSupport = new pageSupport<BizClaimVoucher>();
		try {
			map.put("struts", struts);
			map.put("startDate", startDate);
			map.put("endDate", endDate);
			pageSupport = claimvoucherBiz.page(map, currPageNo,pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
		return SUCCESS;
	}

	public ClaimVoucherBiz getClaimvoucherBiz() {
		return claimvoucherBiz;
	}

	public void setClaimvoucherBiz(ClaimVoucherBiz claimvoucherBiz) {
		this.claimvoucherBiz = claimvoucherBiz;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStruts() {
		return struts;
	}

	public void setStruts(String struts) {
		this.struts = struts;
	}

	public pageSupport<BizClaimVoucher> getPageSupport() {
		return pageSupport;
	}

	public void setPageSupport(pageSupport<BizClaimVoucher> pageSupport) {
		this.pageSupport = pageSupport;
	}

	
	
}
