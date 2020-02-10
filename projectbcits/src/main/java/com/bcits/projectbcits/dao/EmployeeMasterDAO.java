package com.bcits.projectbcits.dao;

import java.util.Date;
import java.util.List;

import com.bcits.projectbcits.bean.ConsumerMasterBean;
import com.bcits.projectbcits.bean.CurrentBill;
import com.bcits.projectbcits.bean.EmployeeMasterBean;
import com.bcits.projectbcits.bean.MonthlyConsumption;

public interface EmployeeMasterDAO {
	
	public EmployeeMasterBean authenticate(int empId,String password);
    public List<ConsumerMasterBean> consumerDetails(String region);
//    public List<MonthlyConsumption> getMonthlyConsumption(int meterNumber);
	/* public long getPreviousReading(int meterNumber); */
    public boolean addCurrentBillToMonthlyConsumption(CurrentBill currentBill);

}
