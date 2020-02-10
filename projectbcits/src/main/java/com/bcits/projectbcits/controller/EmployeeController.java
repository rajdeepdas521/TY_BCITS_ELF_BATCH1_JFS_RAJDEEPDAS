package com.bcits.projectbcits.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.projectbcits.bean.BillHistory;
import com.bcits.projectbcits.bean.ConsumerMasterBean;
import com.bcits.projectbcits.bean.CurrentBill;
import com.bcits.projectbcits.bean.EmployeeMasterBean;
import com.bcits.projectbcits.bean.MonthlyConsumption;
import com.bcits.projectbcits.service.CustomerService;
import com.bcits.projectbcits.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@Autowired
	private CustomerService customerService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@GetMapping("/employeeLoginPage")
	public String consumerLoginPage() {
		return "employeeLogin";
	}

	@GetMapping("/homePage")
	public String homePage() {
		return "homePage";
	}

	@PostMapping("/empLogin")
	public String authenticate(int empId, String password, HttpServletRequest req, ModelMap modelMap) {

		EmployeeMasterBean employeeMasterBean = service.authenticate(empId, password);
		if (employeeMasterBean != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loginEmp", employeeMasterBean);
			return "employeeHeader";
		} else {
			modelMap.addAttribute("errMsg", "Invalid Credential..!!!");
			return "employeeLogin";
		}
	}//End Of Authenticate()
	
	@GetMapping("/employeeDetail")
	public String displayEmployeeDetails(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "please Login...!!!!");
			return "consumerLogin";
		} else {
			return "employeeDetails";
		}
	}// End of displayDetails()
	
	 @GetMapping("/detail")
	 public String displayConsumerDetail(HttpSession session,ModelMap modelMap) {
		 if(session.isNew()) {
			 session.invalidate();
			 modelMap.addAttribute("errMsg", "login First...!!!");
			 return "employeeLogin";
		 }else {
			 return "employeeConsumerDetails";
		 }
	 }//End of DisplayConsumerDetails()
	 @GetMapping("/consumerDetails")
	 public String getConsumer(HttpSession session,ModelMap modelMap) {
		 EmployeeMasterBean employeeMasterBean=(EmployeeMasterBean)session.getAttribute("loginEmp");
		 if(session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "login First...!!!");
			return "employeeLogin";
		 }else {
		      if(employeeMasterBean != null) {
		    	  String region = employeeMasterBean.getRegion();
		    	  List<ConsumerMasterBean> consumerMasterBeans=service.consumerDetails(region);
		    	  System.out.println(consumerMasterBeans);
		    	  modelMap.addAttribute("consumerMasterBeans", consumerMasterBeans);
		    	  return "employeeConsumerDetails";
		      }else {
		    	  modelMap.addAttribute("errMsg", "please Login First..!!!");
		    	  return "employeeLogin";
		      }
		 }
	 }//End Of getConsumer()
	 

		@GetMapping("/emplogout")
		public String consumerLogout(ModelMap modelMap, HttpSession session) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "You Are SuccessFully LoggOut!!!");
			return "homePage";
		}// End Of LogOut()
		
		@GetMapping("/billGeneration")
		public String displayBillGeneration(HttpSession session,ModelMap modelMap) {
			EmployeeMasterBean employeeMasterBean=(EmployeeMasterBean)session.getAttribute("loginEmp");
			if(session.isNew()) {
				session.invalidate();
				modelMap.addAttribute("errMsg", "please Login first...!!");
				return "homePage";
			}else {
				if(employeeMasterBean !=null){
					String region= employeeMasterBean.getRegion();
					List<ConsumerMasterBean> consumerMasterBeans =service.consumerDetails(region);
					modelMap.addAttribute("consumerMasterBeans", consumerMasterBeans);
					return "employeeBillGeneration";
				}else {
					modelMap.addAttribute("errMsg", "unable to load");
					return "consumerLogin";
				}
			}
		}//End of displayBillGeneration
		@GetMapping("/currentBillPageGen")
		public String displayCurrentBillPageGen(HttpSession session,ModelMap modelMap,int meterNumber) {
			EmployeeMasterBean employeeMasterBean=(EmployeeMasterBean)session.getAttribute("loginEmp");
			if (employeeMasterBean != null) {
				ConsumerMasterBean consumerMasterBean=customerService.getConsumer(meterNumber);
				int initialReading= customerService.getPreviousReading(meterNumber);
				if(consumerMasterBean !=null) {
					modelMap.addAttribute("consumerBean", consumerMasterBean);
					modelMap.addAttribute("initialReading", initialReading);
				}
			}else {
				modelMap.addAttribute("errMsg", "Unable to Find");
				return "employeeHome";
			}
			return "currentBillPageGeneration";
		}//End of displayCurrentBillPageGen()
		
		@PostMapping("/generateBillConsumer")
		public String currentBillGeneration(HttpSession session,ModelMap modelMap,CurrentBill currentBill) {
			EmployeeMasterBean employeeMasterBean=(EmployeeMasterBean)session.getAttribute("loginEmp");
			if(employeeMasterBean != null) {
				if(service.addCurrentBillToMonthlyConsumption(currentBill)) {
					modelMap.addAttribute("msg", "Bill Genererated"+currentBill.getMeterNumber()+"SuccessFully..!!");
					
				}else {
					modelMap.addAttribute("errMsg", "Unable to LOad..!!");
				}
				return "employeeBillGeneration";
			}else {
				modelMap.addAttribute("errMsg", "please Login first");
				return "employeeLogin";
			}
		}


}
