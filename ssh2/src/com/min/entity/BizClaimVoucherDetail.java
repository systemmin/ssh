package com.min.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * BizClaimVoucherDetail entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "biz_claim_voucher_detail", catalog = "spring")
public class BizClaimVoucherDetail implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 9151439246721492515L;
	private Integer id;
	private BizClaimVoucher bizClaimVoucher;
	private String item;
	private Double account;
	private String desc;

	// Constructors

	/** default constructor */
	public BizClaimVoucherDetail() {
	}

	/** full constructor */
	public BizClaimVoucherDetail(Integer id, BizClaimVoucher bizClaimVoucher,
			String item, Double account, String desc) {
		this.id = id;
		this.bizClaimVoucher = bizClaimVoucher;
		this.item = item;
		this.account = account;
		this.desc = desc;
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
	@JoinColumn(name = "MAIN_ID", nullable = false)
	public BizClaimVoucher getBizClaimVoucher() {
		return this.bizClaimVoucher;
	}

	public void setBizClaimVoucher(BizClaimVoucher bizClaimVoucher) {
		this.bizClaimVoucher = bizClaimVoucher;
	}

	@Column(name = "ITEM", nullable = false, length = 20)
	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Column(name = "ACCOUNT", nullable = false, precision = 20)
	public Double getAccount() {
		return this.account;
	}

	public void setAccount(Double account) {
		this.account = account;
	}
	@Column(name = "DES", nullable = false, length = 200)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	

}