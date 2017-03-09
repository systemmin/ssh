package com.min.entity;
// default package

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * SysEmployee entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_employee", catalog = "spring")
public class SysEmployee implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 9151439246721492515L;
	private String sn;
	private SysDepartment sysDepartment;
	private SysPosition position;
	private String name;
	private String password;
	private String status;
	private Set<BizClaimVoucher> bizClaimVouchersForNextDealSn = new HashSet<BizClaimVoucher>(
			0);
	private Set<BizClaimVoucher> bizClaimVouchersForCreateSn = new HashSet<BizClaimVoucher>(
			0);

	// Constructors

	/** default constructor */
	public SysEmployee() {
	}

	/** minimal constructor */
	public SysEmployee(String sn, SysDepartment sysDepartment,
			SysPosition position, String name, String password, String status) {
		this.sn = sn;
		this.sysDepartment = sysDepartment;
		this.position = position;
		this.name = name;
		this.password = password;
		this.status = status;
	}

	/** full constructor */
	public SysEmployee(String sn, SysDepartment sysDepartment,
			SysPosition position, String name, String password, String status,
			Set<BizClaimVoucher> bizClaimVouchersForNextDealSn,
			Set<BizClaimVoucher> bizClaimVouchersForCreateSn) {
		this.sn = sn;
		this.sysDepartment = sysDepartment;
		this.position = position;
		this.name = name;
		this.password = password;
		this.status = status;
		this.bizClaimVouchersForNextDealSn = bizClaimVouchersForNextDealSn;
		this.bizClaimVouchersForCreateSn = bizClaimVouchersForCreateSn;
	}

	// Property accessors
	@Id 
    @GenericGenerator(name="generator", strategy="increment")
    @GeneratedValue(generator="generator")
    @Column(name="SN", unique=true, nullable=false)
	public String getSn() {
		return this.sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPARTMENT_ID", nullable = false)
	public SysDepartment getSysDepartment() {
		return this.sysDepartment;
	}

	public void setSysDepartment(SysDepartment sysDepartment) {
		this.sysDepartment = sysDepartment;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "POSITION_ID", nullable = false)
	public SysPosition getPosition() {
		return this.position;
	}

	public void setPosition(SysPosition position) {
		this.position = position;
	}
	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PASSWORD", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "STATUS", nullable = false, length = 20)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysEmployeeByNextDealSn")
	public Set<BizClaimVoucher> getBizClaimVouchersForNextDealSn() {
		return this.bizClaimVouchersForNextDealSn;
	}

	public void setBizClaimVouchersForNextDealSn(
			Set<BizClaimVoucher> bizClaimVouchersForNextDealSn) {
		this.bizClaimVouchersForNextDealSn = bizClaimVouchersForNextDealSn;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysEmployeeByCreateSn")
	public Set<BizClaimVoucher> getBizClaimVouchersForCreateSn() {
		return this.bizClaimVouchersForCreateSn;
	}

	public void setBizClaimVouchersForCreateSn(
			Set<BizClaimVoucher> bizClaimVouchersForCreateSn) {
		this.bizClaimVouchersForCreateSn = bizClaimVouchersForCreateSn;
	}

}