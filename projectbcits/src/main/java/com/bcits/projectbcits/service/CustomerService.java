package com.bcits.projectbcits.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;


import com.bcits.projectbcits.bean.BillHistory;
import com.bcits.projectbcits.bean.ConsumerMasterBean;
import com.bcits.projectbcits.bean.CurrentBill;
import com.bcits.projectbcits.bean.MonthlyConsumption;




public interface CustomerService {
	

	   public boolean registerConsumer(ConsumerMasterBean consumerMasterBean,String confirmPassword);
	   public ConsumerMasterBean authenticate(int meterNumber,String password);

	/* public BillHistory billDetails(int meterNumber); */
	   public List<BillHistory> getBillHistory(int meterNumber);
	   public MonthlyConsumption getMonthlyConsumption(int meterNumber);
	   public CurrentBill getCurrentBill(int meterNumber);
	   
	   public boolean successfullBillPayment(int meterNumber,Date dueDate,double billAmount);
	   public ConsumerMasterBean getConsumer(int meterNumber);
	   public int getPreviousReading(int meterNumber);
	
}
