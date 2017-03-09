package com.min.entity;
// default package

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * BizCheckResult entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "biz_check_result", catalog = "spring")
public class BizCheckResult implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 1L;
	private Integer id;
	private BizClaimVoucher bizClaimVoucher;
	private Date checkTime;
	private String checkerSn;
	private String result;
	private String comm;

	// Constructors

	/** default constructor */
	public BizCheckResult() {
	}

	/** full constructor */
	public BizCheckResult(Integer id, BizClaimVoucher bizClaimVoucher,
			Date checkTime, String checkerSn, String result, String comm) {
		this.id = id;
		this.bizClaimVoucher = bizClaimVoucher;
		this.checkTime = checkTime;
		this.checkerSn = checkerSn;
		this.result = result;
		this.comm = comm;
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
	@JoinColumn(name = "CLAIM_ID", nullable = false)
	public BizClaimVoucher getBizClaimVoucher() {
		return this.bizClaimVoucher;
	}

	public void setBizClaimVoucher(BizClaimVoucher bizClaimVoucher) {
		this.bizClaimVoucher = bizClaimVoucher;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CHECK_TIME", nullable = false, length = 0)
	public Date getCheckTime() {
		return this.checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	@Column(name = "CHECKER_SN", nullable = false, length = 50)
	public String getCheckerSn() {
		return this.checkerSn;
	}

	public void setCheckerSn(String checkerSn) {
		this.checkerSn = checkerSn;
	}

	@Column(name = "RESULT", nullable = false, length = 50)
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Column(name = "COMM", nullable = false, length = 500)
	public String getComm() {
		return this.comm;
	}

	public void setComm(String comm) {
		this.comm = comm;
	}

}