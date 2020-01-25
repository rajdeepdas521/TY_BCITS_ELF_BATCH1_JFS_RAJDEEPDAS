package com.bcits.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.bcits.springmvc.beans.EmployeeInfoBean;
import com.bcits.springmvc.dao.EmployeeDAO;
import com.bcits.springmvc.dao.EmployeeDAOimpl;
import com.bcits.springmvc.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
  
	@GetMapping("/login")
	public String displyLoginForm() {
		return "empLoginForm";
	}
	
	@PostMapping("/login")
	public String authenticate(int empId,String password, HttpServletRequest req, ModelMap modelMap) {
		EmployeeDAO dao=new EmployeeDAOimpl();
		EmployeeInfoBean employeeInfoBean = dao.authenticate(empId,password);
		
		if(employeeInfoBean!=null) {
			HttpSession session=req.getSession(true);
			session.setAttribute("loggedInEmpInfo", employeeInfoBean);
			
			return "employeeHome";
		}else {
			modelMap.addAttribute("errMsg", "Invalid Credential..!!!");
		    return "empLoginForm";
		}
	}// End of authenticate
	
	@GetMapping("/searchEmpForm")
	public String displaySearchEmployeeForm(HttpSession session, ModelMap modelMap) {
		  if(session.isNew()) {
			  session.invalidate();
			  
			  modelMap.addAttribute("errMsg", "please login first");
			  return "empLoginForm";
		  }else {
			  return "searchEmpForm";
		  }
	}//End of DisplaySearch
	
	@GetMapping("/search")
	public String searchEmployee(int empId, HttpSession session, ModelMap modelMap) {
		  if(session.getAttribute("loggedInEmpInfo")!=null) {
			//  EmployeeDAO dao =new EmployeeDAOimpl();
			  EmployeeInfoBean employeeInfoBean =service.getEmployee(empId);
			  
			  if(employeeInfoBean !=null) {
				  modelMap.addAttribute("employeeInfoBean", employeeInfoBean);
			  } else {
				  modelMap.addAttribute("errMsg", "Employee ID Not Found");
			  }
			   return "searchEmpForm";
		  } else {
			  modelMap.addAttribute("errMsg", "Please Login First");
			  return "empLoginForm";
		  }
	}//
	
	@GetMapping("/deleteEmpForm")
	public String displayDeleteEmployeeForm(@SessionAttribute(name="loggedInEmpInfo",required = false)EmployeeInfoBean employeeInfoBean,
			ModelMap  modelMap) {
		if(employeeInfoBean != null) {
			return "deleteEmpForm";
		} else {
			modelMap.addAttribute("errMsg", "please Login First");
			return "empLoginForm";
		}
	}
	
	@GetMapping("/delete")
	public String deleteEmployee(int empId,@SessionAttribute(name="loggedInEmpInfo",required = false)EmployeeInfoBean employeeInfoBean,
			ModelMap  modelMap) {
		if(employeeInfoBean != null) {
			if(service.deleteEmployee(empId)) {
				modelMap.addAttribute("msg", "Employee Record Deleted Succesfully...");
			}else {
				modelMap.addAttribute("errMsg", "Employee ID not found");
			}
			return "deleteEmpForm";
		}else {
			modelMap.addAttribute("errMsg", "please login First !!");
			return "empLoginForm";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,ModelMap modelMap) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "You Are SuccessFully LoggOut!!!");
		
		return "empLoginForm";
	}// End Of Logout
	
	
}
