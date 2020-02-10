package com.bcits.projectbcits.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcits.projectbcits.bean.BillHistory;
import com.bcits.projectbcits.bean.ConsumerMasterBean;
import com.bcits.projectbcits.bean.CurrentBill;
import com.bcits.projectbcits.bean.MonthlyConsumption;
import com.bcits.projectbcits.dao.ConsumerMasterDao;


@Service
public class ConsumerServiceImpl implements CustomerService {

	@Autowired
	private ConsumerMasterDao dao;
	
	@Override
	public boolean registerConsumer(ConsumerMasterBean consumerMasterBean, String confirmPassword) {
		if(!consumerMasterBean.getPassword().equals(confirmPassword)) {
			return false;
		}
	return dao.registerConsumer(consumerMasterBean);
	}

	@Override
	public ConsumerMasterBean authenticate(int meterNumber, String password) {
	
		return dao.authenticate(meterNumber, password);
	}

	@Override
	public List<BillHistory> getBillHistory(int meterNumber) {
		
		return dao.getBillHistory(meterNumber);
	}

	@Override
	public MonthlyConsumption getMonthlyConsumption(int meterNumber) {
		
		return dao.getMonthlyConsumption(meterNumber);
	}
	@Override
	public CurrentBill getCurrentBill(int meterNumber) {
		
		return dao.getCurrentBill(meterNumber);
	}

	@Override
	public boolean successfullBillPayment(int meterNumber, Date dueDate, double billAmount) {
		
		return dao.successfullBillPayment(meterNumber, dueDate, billAmount);
	}

	@Override
	public ConsumerMasterBean getConsumer(int meterNumber) {
		
		return dao.getConsumer(meterNumber);
	}

	@Override
	public int getPreviousReading(int meterNumber) {
		return dao.getPreviousReading(meterNumber);
	}

	

	
}
