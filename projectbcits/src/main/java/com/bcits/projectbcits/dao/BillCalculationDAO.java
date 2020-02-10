package com.bcits.projectbcits.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bcits.projectbcits.bean.TarrifMasterBean;

@Repository
public class BillCalculationDAO {

	@PersistenceUnit
	private EntityManagerFactory factory;
	
	public double billCalculation(int totalUnit, String type) {
		EntityManager manager=factory.createEntityManager();
		String jpql="from TarrifMasterBean where consumerType= :consumerType";
		Query query= manager.createQuery(jpql);
		query.setParameter("consumerType", type);
		List<TarrifMasterBean> tarrifMasterBean= (List<TarrifMasterBean>)query.getResultList();
		
		int firstRange= tarrifMasterBean.get(0).getTarrifMasterPk().getRange();
		int secondRange=tarrifMasterBean.get(1).getTarrifMasterPk().getRange();
		int thirdRange=tarrifMasterBean.get(2).getTarrifMasterPk().getRange();
		
		int firstAmount=tarrifMasterBean.get(0).getAmount();
		int secondAmount=tarrifMasterBean.get(1).getAmount();
		int thirdAmount=tarrifMasterBean.get(2).getAmount();
		
		double billAmount=0.0;
		if(totalUnit < firstRange) {
	     billAmount =totalUnit*firstAmount;
	     
		}else if(totalUnit < secondRange) {
			billAmount=(firstRange *firstAmount)+((totalUnit - firstRange)*secondAmount);
		}else if(totalUnit > thirdRange) {
			billAmount=(firstRange *firstAmount)+((secondRange - firstRange)*secondAmount)+((totalUnit - secondRange));
		}
				return billAmount;
	
	}
}
