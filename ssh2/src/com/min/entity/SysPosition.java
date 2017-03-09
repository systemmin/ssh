package com.min.entity;
// default package

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * SysPosition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_position", catalog = "spring")
public class SysPosition implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 9151439246721492515L;
	private Integer id;
	private String nameCn;
	private String nameEn;
	private Set<SysEmployee> sysEmployees = new HashSet<SysEmployee>(0);
	// Constructors

	/** default constructor */
	public SysPosition() {
	}

	/** full constructor */


	// Property accessors
	@Id 
    @GenericGenerator(name="generator", strategy="uuid")
    @GeneratedValue(generator="generator")
    @Column(name="ID", unique=true, nullable=false)
	public Integer getId() {
		return this.id;
	}

	public SysPosition(Integer id, String nameCn, String nameEn,
			Set<SysEmployee> sysEmployees) {
		this.id = id;
		this.nameCn = nameCn;
		this.nameEn = nameEn;
		this.sysEmployees = sysEmployees;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "NAME_CN", nullable = false, length = 50)
	public String getNameCn() {
		return this.nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	@Column(name = "NAME_EN", nullable = false, length = 50)
	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "position")
	public Set<SysEmployee> getSysEmployees() {
		return this.sysEmployees;
	}

	public void setSysEmployees(Set<SysEmployee> sysEmployees) {
		this.sysEmployees = sysEmployees;
	}
}