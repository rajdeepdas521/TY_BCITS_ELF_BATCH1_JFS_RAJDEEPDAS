package com.bcits.projectbcits.dao;

import java.util.Date;
import java.util.List;

import com.bcits.projectbcits.bean.BillHistory;
import com.bcits.projectbcits.bean.ConsumerMasterBean;
import com.bcits.projectbcits.bean.CurrentBill;
import com.bcits.projectbcits.bean.MonthlyConsumption;




public interface ConsumerMasterDao {
  

	 public boolean registerConsumer(ConsumerMasterBean consumerMasterBean);
	 public ConsumerMasterBean authenticate(int meterNumber,String password);
	 public List<BillHistory> getBillHistory(int meterNumber);
	 public MonthlyConsumption getMonthlyConsumption(int meterNumber);
	 public CurrentBill getCurrentBill(int meterNumber);
	 public boolean successfullBillPayment(int meterNumber,Date dueDate,double billAmount);
	 public ConsumerMasterBean getConsumer(int meterNumber);
	 public int getPreviousReading(int meterNumber);

}
