package com.min.action;

import org.apache.struts2.ServletActionContext;

import com.min.biz.SysEmployeeBiz;
import com.min.entity.SysEmployee;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 用户登录Action
 * 
 * @author ming
 * 
 */
public class SysEmployeeAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private SysEmployeeBiz sysEmployeeBiz;

	private SysEmployee employee ;

	public String login()throws Exception {
		SysEmployee result = sysEmployeeBiz.checkLogin(employee);
		if (result!=null) {
			ServletActionContext.getContext().getSession().put("employee", result);
			ServletActionContext.getContext().getSession().put("employee_position", result.getPosition().getNameCn());
		}else {
			return INPUT;
		}
		return SUCCESS;
	}

	public void setSysEmployeeBiz(SysEmployeeBiz sysEmployeeBiz) {
		this.sysEmployeeBiz = sysEmployeeBiz;
	}


	public SysEmployee getEmployee() {
		return employee;
	}

	public void setEmployee(SysEmployee employee) {
		this.employee = employee;
	}
	
	
}
