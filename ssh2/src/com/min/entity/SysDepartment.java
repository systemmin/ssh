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
 * SysDepartment entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sys_department", catalog = "spring")
public class SysDepartment implements java.io.Serializable {

	// Fields
	private static final long serialVersionUID = 9151439246721492515L;
	private Integer id;
	private String name;
	private Set<SysEmployee> sysEmployees = new HashSet<SysEmployee>(0);

	// Constructors

	/** default constructor */
	public SysDepartment() {
	}

	/** minimal constructor */
	public SysDepartment(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public SysDepartment(Integer id, String name, Set<SysEmployee> sysEmployees) {
		this.id = id;
		this.name = name;
		this.sysEmployees = sysEmployees;
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

	@Column(name = "NAME", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "sysDepartment")
	public Set<SysEmployee> getSysEmployees() {
		return this.sysEmployees;
	}

	public void setSysEmployees(Set<SysEmployee> sysEmployees) {
		this.sysEmployees = sysEmployees;
	}

}