package com.bcits.projectbcits.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.bcits.projectbcits.bean.ConsumerMasterBean;
import com.bcits.projectbcits.bean.CurrentBill;
import com.bcits.projectbcits.bean.EmployeeMasterBean;
import com.bcits.projectbcits.bean.MonthlyConsumption;
import com.bcits.projectbcits.bean.MonthlyConsumptionPk;
@Repository
public class EmployeeImplDAO implements EmployeeMasterDAO {
	
	@PersistenceUnit
	EntityManagerFactory factory;
	
	@Autowired
	private BillCalculationDAO generateBill;


	@Override
	public List<ConsumerMasterBean> consumerDetails(String region) {
		EntityManager manager=factory.createEntityManager();
		String jpql="from ConsumerMasterBean where region= :regionName";
		Query query=manager.createQuery(jpql);
		query.setParameter("regionName", region);
		List<ConsumerMasterBean> consumerMasterBean=(List<ConsumerMasterBean>)query.getResultList();
		if(consumerMasterBean!=null) {
			return consumerMasterBean;
		}
		manager.close();
		return null;
	}// End of consumerDetails()

	@Override
	public EmployeeMasterBean authenticate(int empId, String password) {
		EntityManager manager = factory.createEntityManager();
		EmployeeMasterBean employeeMasterBean = manager.find(EmployeeMasterBean.class, empId);
		
		if(employeeMasterBean !=null && employeeMasterBean.getPassword().equals(password)) {
			return employeeMasterBean;
		}else {
			return null;
		}
		
	}// End of authenticate



	@Override
	public boolean addCurrentBillToMonthlyConsumption(CurrentBill currentBill) {
		int units= currentBill.getFinalReading()-currentBill.getInitialReading();
		System.out.println(currentBill.getFinalReading());
		EntityManager manager  = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		
		MonthlyConsumption monthlyConsumption = new MonthlyConsumption();
		MonthlyConsumptionPk monthlyConsumptionPk = new MonthlyConsumptionPk();
		
		CurrentBill bill = manager.find(CurrentBill.class, currentBill.getMeterNumber());
		String type= currentBill.getConsumerType();
		double billAmount = generateBill.billCalculation(units, currentBill.getConsumerType());
		
		try {
			transaction.begin();
			if(bill !=null) {
				manager.remove(bill);
			}
			monthlyConsumption.setBillAmount(billAmount);
			monthlyConsumption.setInitialReading(currentBill.getInitialReading());
			monthlyConsumption.setFinalReading(currentBill.getFinalReading());
			monthlyConsumption.setTotalUnit(units);
			monthlyConsumptionPk.setDate(new Date());
			monthlyConsumptionPk.setMeterNumber(currentBill.getMeterNumber());
			monthlyConsumption.setMonthlyConsumptionpk(monthlyConsumptionPk);
			currentBill.setBillAmount(billAmount);
			currentBill.setConsuptionUnits(units);
		    manager.persist(monthlyConsumption);
		    manager.persist(currentBill);
		    transaction.commit();
		    return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}// End Of addCurrentBillToMonthlyConsumption()

}
