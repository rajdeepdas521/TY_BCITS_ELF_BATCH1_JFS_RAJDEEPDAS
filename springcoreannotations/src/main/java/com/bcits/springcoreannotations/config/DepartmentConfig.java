package com.bcits.springcoreannotations.config;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import com.bcits.springcoreannotations.beans.DepartmentBean;
@Configuration
public class DepartmentConfig {

	@Bean(name = "dev")
	public DepartmentBean getDepartmentBean() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptId(100);
		departmentBean.setDeptName("HR");
		return departmentBean;
	}

	@Bean(name = "hr")
	public DepartmentBean getDeptHR() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptId(110);
		departmentBean.setDeptName("HR");
		return departmentBean;
	}

	@Bean(name = "acc")
//	@Primary
	public DepartmentBean getDeptDev() {
		DepartmentBean departmentBean = new DepartmentBean();
		departmentBean.setDeptId(120);
		departmentBean.setDeptName("developer");
		return departmentBean;
	}
}
