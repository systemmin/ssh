package com.min.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.biz.SysEmployeeBiz;
import com.min.dao.SysEmployeeDao;
import com.min.entity.SysEmployee;

@Service("sysEmployeeBiz")
//发生以下bu异常回滚、类型
//@Transactional(noRollbackFor={IOException.class,NoClassDefFoundError.class})
// 包名＋类名
//@Transactional(noRollbackForClassName={"..IOException","..NoClassDefFoundError"})
// 回滚
//@Transactional(rollbackFor={IOException.class,NullPointerException.class})
@Transactional()
public class SysEmployeeBizImpl implements SysEmployeeBiz {

	private SysEmployeeDao employeeDao;
	
	@Autowired
	public void setEmployeeDao(SysEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	//@Transactional(propagation=Propagation.SUPPORTS)//
	public SysEmployee checkLogin(SysEmployee sysEmployee) {
		SysEmployee sEmployee = employeeDao.get(SysEmployee.class,sysEmployee.getSn());
		if (sEmployee !=null && sEmployee.getPassword().equals(sysEmployee.getPassword())) {
			return sEmployee;
		}
		return null;
	}

}
