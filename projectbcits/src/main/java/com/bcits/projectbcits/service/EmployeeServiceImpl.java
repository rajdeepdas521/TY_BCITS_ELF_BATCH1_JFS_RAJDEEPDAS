package com.bcits.projectbcits.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.projectbcits.bean.ConsumerMasterBean;
import com.bcits.projectbcits.bean.CurrentBill;
import com.bcits.projectbcits.bean.EmployeeMasterBean;
import com.bcits.projectbcits.bean.MonthlyConsumption;
import com.bcits.projectbcits.dao.EmployeeMasterDAO;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	   @Autowired
       private EmployeeMasterDAO dao;
	
	@Override
	public List<ConsumerMasterBean> consumerDetails(String region) {
		
		return dao.consumerDetails(region);
	}

	@Override
	public EmployeeMasterBean authenticate(int empId, String password) {
		
		return dao.authenticate(empId, password);
	}

	@Override
	public boolean addCurrentBillToMonthlyConsumption(CurrentBill currentBill) {
		
		return dao.addCurrentBillToMonthlyConsumption(currentBill);
	}



}
