package com.bcits.springmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bcits.springmvc.beans.EmployeeInfoBean;
@Repository
public class EmployeeDAOimpl implements EmployeeDAO {
   // @PersistenceUnit
	@Autowired
	private EntityManagerFactory factory;

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		boolean isAdded = false;
		try {
			transaction.begin();
			manager.persist(employeeInfoBean);
			transaction.commit();
			isAdded = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		manager.close();
		factory.close();

		return isAdded;
	}

	@Override
	public boolean deleteEmployee(int empId) {
		boolean isDeleted = false;

		EntityManager manager = factory.createEntityManager();
		
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		if (employeeInfoBean != null) {
			EntityTransaction transaction=manager.getTransaction();
			transaction.begin();
			manager.remove(employeeInfoBean);
			transaction.commit();
			isDeleted=true;
			
		}
		return isDeleted;
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {

		return false;
	}

	@Override
	public EmployeeInfoBean getEmployee(int empId) {
		EntityManager manager = factory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		manager.close();
		return employeeInfoBean;
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		EntityManager manager = factory.createEntityManager();
		String jpql = " from EmployeePrimaryInfo";
		Query query = manager.createQuery(jpql);
		List<EmployeeInfoBean> employeesList = query.getResultList();

		manager.close();
		return employeesList;
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		EntityManager manager = factory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, empId);
		
		if(employeeInfoBean !=null && employeeInfoBean.getPassword().equals(password)) {
			return employeeInfoBean;
		} else {
			return null;
		}
		
	}

}
