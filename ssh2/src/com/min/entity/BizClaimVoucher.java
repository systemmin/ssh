package com.min.entity;
// default package

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * BizClaimVoucher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "biz_claim_voucher", catalog = "spring")
public class BizClaimVoucher implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 9151439246721492515L;
	private Integer id;
	private SysEmployee sysEmployeeByNextDealSn;
	private SysEmployee sysEmployeeByCreateSn;
	private Date createTime;
	private String event;
	private Double totalAccount;
	private String status;
	private Date modifyTime;
	private Set<BizCheckResult> bizCheckResults = new HashSet<BizCheckResult>(0);
	private Set<BizClaimVoucherDetail> bizClaimVoucherDetails = new HashSet<BizClaimVoucherDetail>(
			0);

	// Constructors

	/** default constructor */
	public BizClaimVoucher() {
	}

	/** minimal constructor */
	public BizClaimVoucher(SysEmployee sysEmployeeByCreateSn,
			Timestamp createTime, String event, Double totalAccount,
			String status) {
		this.sysEmployeeByCreateSn = sysEmployeeByCreateSn;
		this.createTime = createTime;
		this.event = event;
		this.totalAccount = totalAccount;
		this.status = status;
	}

	/** full constructor */
	public BizClaimVoucher(SysEmployee sysEmployeeByNextDealSn,
			SysEmployee sysEmployeeByCreateSn, Timestamp createTime,
			String event, Double totalAccount, String status,
			Timestamp modifyTime, Set<BizCheckResult> bizCheckResults,
			Set<BizClaimVoucherDetail> bizClaimVoucherDetails) {
		this.sysEmployeeByNextDealSn = sysEmployeeByNextDealSn;
		this.sysEmployeeByCreateSn = sysEmployeeByCreateSn;
		this.createTime = createTime;
		this.event = event;
		this.totalAccount = totalAccount;
		this.status = status;
		this.modifyTime = modifyTime;
		this.bizCheckResults = bizCheckResults;
		this.bizClaimVoucherDetails = bizClaimVoucherDetails;
	}

	// Property accessors
	@Id 
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    @Column(name="ID", unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "NEXT_DEAL_SN")
	public SysEmployee getSysEmployeeByNextDealSn() {
		return this.sysEmployeeByNextDealSn;
	}

	public void setSysEmployeeByNextDealSn(SysEmployee sysEmployeeByNextDealSn) {
		this.sysEmployeeByNextDealSn = sysEmployeeByNextDealSn;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATE_SN", nullable = false)
	public SysEmployee getSysEmployeeByCreateSn() {
		return this.sysEmployeeByCreateSn;
	}

	public void setSysEmployeeByCreateSn(SysEmployee sysEmployeeByCreateSn) {
		this.sysEmployeeByCreateSn = sysEmployeeByCreateSn;
	}

	@Column(name = "CREATE_TIME", nullable = false, length = 0)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "EVENT", nullable = false)
	public String getEvent() {
		return this.event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	@Column(name = "TOTAL_ACCOUNT", nullable = false, precision = 20)
	public Double getTotalAccount() {
		return this.totalAccount;
	}

	public void setTotalAccount(Double totalAccount) {
		this.totalAccount = totalAccount;
	}

	@Column(name = "STATUS", nullable = false, length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "MODIFY_TIME", length = 0)
	public Date getModifyTime() {
		return this.modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bizClaimVoucher")
	public Set<BizCheckResult> getBizCheckResults() {
		return this.bizCheckResults;
	}

	public void setBizCheckResults(Set<BizCheckResult> bizCheckResults) {
		this.bizCheckResults = bizCheckResults;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bizClaimVoucher")
	public Set<BizClaimVoucherDetail> getBizClaimVoucherDetails() {
		return this.bizClaimVoucherDetails;
	}

	public void setBizClaimVoucherDetails(
			Set<BizClaimVoucherDetail> bizClaimVoucherDetails) {
		this.bizClaimVoucherDetails = bizClaimVoucherDetails;
	}

}