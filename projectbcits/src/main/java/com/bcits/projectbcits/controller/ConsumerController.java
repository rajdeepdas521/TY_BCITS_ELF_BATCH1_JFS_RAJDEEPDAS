package com.bcits.projectbcits.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bcits.projectbcits.bean.BillHistory;
import com.bcits.projectbcits.bean.ConsumerMasterBean;
import com.bcits.projectbcits.bean.CurrentBill;
import com.bcits.projectbcits.bean.MonthlyConsumption;
import com.bcits.projectbcits.service.CustomerService;

@Controller
public class ConsumerController {

	@Autowired
	private CustomerService service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		CustomDateEditor dateEditor = new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true);
		binder.registerCustomEditor(Date.class, dateEditor);
	}

	@GetMapping("/signUpPage")
	public String displySignUpPage() {
		return "signUpPage";
	}

	@GetMapping("/consumerLoginPage")
	public String consumerLoginPage() {
		return "consumerLogin";
	}

	@PostMapping("/addConsumer")
	public String addConsumerDetails(ConsumerMasterBean consumerMasterBean, ModelMap modelMap, String confirmPassword) {
		if (service.registerConsumer(consumerMasterBean, confirmPassword)) {
			modelMap.addAttribute("msg", "SuccesFully register....!!!!");
			return "consumerLogin";
		} else {
			modelMap.addAttribute("errMsg", "Register Failed...!!!!");
			return "signUpPage";
		}
	}// End Of AddConsumerDetails()

	/*
	 * @GetMapping("/consumerloginPage") public String displyLoginForm() { return
	 * "consumerLogin"; }
	 */

	@PostMapping("/consumerlogin")
	public String authenticate(int meterNumber, String password, HttpServletRequest req, ModelMap modelMap) {

		ConsumerMasterBean consumerMasterBean = service.authenticate(meterNumber, password);
		if (consumerMasterBean != null) {
			HttpSession session = req.getSession(true);
			session.setAttribute("loggedInConsumer", consumerMasterBean);

			return "consumerHeader";
		} else {
			modelMap.addAttribute("errMsg", "Invalid Credential..!!!");

			return "consumerLogin";
		}
	}// End of authenticate()

	@GetMapping("/logout")
	public String consumerLogout(ModelMap modelMap, HttpSession session) {
		session.invalidate();
		modelMap.addAttribute("errMsg", "You Are SuccessFully LoggOut!!!");
		return "homePage";
	}// End Of LogOut()

	@GetMapping("/consumerDetail")
	public String displayDetails(HttpSession session, ModelMap modelMap) {
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "please Login...!!!!");
			return "consumerLogin";
		} else {
			return "consumerDetails";
		}
	}// End of displayDetails()

	/*
	 * @GetMapping("/billHistoryPage") public String billDetail() {
	 * if(session.isNew()) { session.invalidate(); modelMap.addAttribute("errMsg",
	 * "Invalid Credentials"); return "consumerLogin"; }else { return "billHistory";
	 * } //End Of billDetails
	 */
	@GetMapping("/search")
	public String getBill(HttpSession session, ModelMap modelMap) {
		ConsumerMasterBean consumerMasterBean = (ConsumerMasterBean) session.getAttribute("loggedInConsumer");
		if (consumerMasterBean != null) {
			List<BillHistory> billHistories = service.getBillHistory(consumerMasterBean.getMeterNumber());
			if (billHistories != null) {
				modelMap.addAttribute("billHistory", billHistories);
				return "billHistory";
			} else {
				modelMap.addAttribute("errMsg", "Employee ID Not Found");
				return "consumerLogin";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First");

			return "consumerLogin";
		}
	}// End Of getBill()

	@GetMapping("/monthlyConsumption")
	public String displaymonthlyConsumption(HttpSession session, ModelMap modelMap) {
		ConsumerMasterBean consumerMasterBean = (ConsumerMasterBean) session.getAttribute("loggedInConsumer");
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "Not Found..>!!!");
			return "consumerLogin";
		} else {
			if (consumerMasterBean != null) {
				int meterNumber = consumerMasterBean.getMeterNumber();
				MonthlyConsumption monthlyConsumption = service.getMonthlyConsumption(meterNumber);
				modelMap.addAttribute("msg", monthlyConsumption);
				return "monthlyConsumption";
			} else {
				modelMap.addAttribute("errMsg", "not Foundd..!!!");
				return "consumerLogin";
			}
		}
	}// End of displayMonthlyConsumption()

	@GetMapping("/displayCurrentBill")
	public String currentBill(HttpSession session, ModelMap modelMap) {
		ConsumerMasterBean consumerMasterBean = (ConsumerMasterBean) session.getAttribute("loggedInConsumer");
		if (consumerMasterBean != null) {
			CurrentBill currentBill = service.getCurrentBill(consumerMasterBean.getMeterNumber());
			if (currentBill != null) {
				modelMap.addAttribute("currentBill", currentBill);
				return "currentBill";
			} else {
				modelMap.addAttribute("errMsg", "Please Login First...!!");
				return "consumerLogin";
			}
		} else {
			modelMap.addAttribute("errMsg", "Please Login First...!!");
			return "consumerLogin";
		}
	}// End Of CUrrent Bill()

	@GetMapping("/onlinePayment")
	public String DisplayOnlinePayment(HttpSession session, ModelMap modelMap) {
		ConsumerMasterBean consumerMasterBean = (ConsumerMasterBean) session.getAttribute("loggedInConsumer");
		if (consumerMasterBean != null) {
			return "paymentPage";
		} else {
			modelMap.addAttribute("errMsg", "please Login First..!!!");
			return "consumerLogin";
		}
	}//End Of displayOnlinePayment()

	@GetMapping("/paymentPage")
	public String displayPaymentPage(HttpSession session, ModelMap modelMap) {
		ConsumerMasterBean consumerMasterBean = (ConsumerMasterBean) session.getAttribute("loggedInConsumer");
		if (session.isNew()) {
			session.invalidate();
			modelMap.addAttribute("errMsg", "please Login...!!!");
			return "consumerLogin";
		} else {
			if (consumerMasterBean != null) {
				int meterNumber = consumerMasterBean.getMeterNumber();
				BillHistory billHistory = (BillHistory) service.getBillHistory(meterNumber);
				modelMap.addAttribute("billHistory", billHistory);
				return "paymentPage";
			} else {
				modelMap.addAttribute("errMsg", "Unable To Pay");
				return "consumerLogin";
			}
		}
	}//End Of displayPaymentPage()

}
