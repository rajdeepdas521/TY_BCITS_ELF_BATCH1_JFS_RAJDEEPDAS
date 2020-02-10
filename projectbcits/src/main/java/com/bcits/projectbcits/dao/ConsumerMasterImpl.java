package com.bcits.projectbcits.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;


import com.bcits.projectbcits.bean.BillHistory;
import com.bcits.projectbcits.bean.BillHistoryBeanPK;
import com.bcits.projectbcits.bean.ConsumerMasterBean;
import com.bcits.projectbcits.bean.CurrentBill;
import com.bcits.projectbcits.bean.MonthlyConsumption;



@Repository
public class ConsumerMasterImpl implements ConsumerMasterDao {

	@PersistenceUnit
	EntityManagerFactory factory;
	

	@Override
	public boolean registerConsumer(ConsumerMasterBean consumerMasterBean) {
		EntityManager	manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		
		try {
			transaction.begin();
			manager.persist(consumerMasterBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		
		return false;
	}

	@Override
	public ConsumerMasterBean authenticate(int meterNumber, String password) {
			EntityManager manager = factory.createEntityManager();
		    ConsumerMasterBean consumerMasterBean = manager.find(ConsumerMasterBean.class, meterNumber);
			
			if(consumerMasterBean !=null && consumerMasterBean.getPassword().equals(password)) {
				return consumerMasterBean;
			} else {
				return null;
			}
			
		}

	/*
	 * @Override public BillHistory billDetails(int meterNumber) { EntityManager
	 * manager = factory.createEntityManager(); BillHistory
	 * billHistory=manager.find(BillHistory.class, meterNumber); manager.close();
	 * return billHistory;
	 * 
	 * }
	 */

	@Override
	public List<BillHistory> getBillHistory(int meterNumber) {
		EntityManager manager=factory.createEntityManager();
		Query query=manager.createQuery("from BillHistory where meterNumber= : mnum");
		query.setParameter("mnum", meterNumber);
		List<BillHistory> billHistories=query.getResultList();
		if(billHistories!=null) {
			return billHistories;
		}
		manager.close();
		return null;
	}

	@Override
	public MonthlyConsumption getMonthlyConsumption(int meterNumber) {
		EntityManager manager=factory.createEntityManager();
		String jpql="from MonthlyConsumption where meterNumber= :mnum";
		Query query=manager.createQuery(jpql);
		query.setParameter("mnum", meterNumber);
		MonthlyConsumption monthlyConsumption=(MonthlyConsumption)query.getSingleResult();
		if(monthlyConsumption!=null) {
			return monthlyConsumption;
		}
		return null;
	}

	@Override
	public boolean successfullBillPayment(int meterNumber, Date dueDate, double billAmount) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction=manager.getTransaction();
		BillHistory billHistory=new BillHistory();
		BillHistoryBeanPK beanPK=new BillHistoryBeanPK();
		billHistory.setBillAmount(billAmount);
		billHistory.setStatus("Paid");
		
		beanPK.setMeterNumber(meterNumber);
		beanPK.setDueDate(dueDate);
		
		billHistory.setBeanPK(beanPK);
		boolean isAdded=true;
		if(isAdded) {
			transaction.begin();
			manager.persist(billHistory);
			transaction.commit();
			return isAdded;
		} else {
			return false;
		}
		
	}//End of Method

	@Override
	public CurrentBill getCurrentBill(int meterNumber) {
		EntityManager manager=factory.createEntityManager();
		CurrentBill currentBill=manager.find(CurrentBill.class, meterNumber);
		if(currentBill!=null) {
			return currentBill;
		}
		manager.close();
		return null;
	}

	@Override
	public ConsumerMasterBean getConsumer(int meterNumber) {
		EntityManager manager = factory.createEntityManager();
		ConsumerMasterBean conInfoBean = manager.find(ConsumerMasterBean.class, meterNumber);
		if(conInfoBean != null) {
			return conInfoBean;
		}
		manager.close();
		return null;
	}

	@Override
	public int getPreviousReading(int meterNumber) {
		EntityManager manager = factory.createEntityManager();
		String jpql =" select initialReading from CurrentBill where meterNumber= :rrNum ";
		Query query = manager.createQuery(jpql);
		query.setParameter("rrNum", meterNumber);
		int previous = (int) query.getSingleResult();
		if(previous != 0) {
			return previous;
		}
		return 0;
	}
}


