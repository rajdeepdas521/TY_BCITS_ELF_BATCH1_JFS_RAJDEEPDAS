package com.bcits.springrestjaxb.jsontest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtherInfoBean;

public class UserJSONMarshalling {
	
	public static void main(String[] args) {

		UserInfoBean userInfo =new UserInfoBean();
		userInfo.setEmpId(2222);
		userInfo.setDeptId(22);
		userInfo.setBloodgroup("B+ve");
		userInfo.setDesignation("SoftWare Developer");
		userInfo.setDob(new Date());
		userInfo.setJoiningDate(new Date());
		userInfo.setManagerId(20);
		userInfo.setMobile(8986826174L);
		userInfo.setName("Raghu");
		userInfo.setOfficialmailId("raghu@gmail.com");
		userInfo.setSalary(30000);
		
		UserOtherInfoBean userOtherInfo =new UserOtherInfoBean();
		userOtherInfo.setGender("Male");
		userOtherInfo.setAadharNumber(123456789L);
		
		UserAddressBean addressBean=new UserAddressBean();
		addressBean.setCity("BLR");
		addressBean.setAddressType('t');
		addressBean.setHouseNum(55);
		
		UserAddressBean pAddressBean=new UserAddressBean();
		pAddressBean.setHouseNum(5);
		pAddressBean.setStreet("XYZ street");
		pAddressBean.setCity("HYD");
		pAddressBean.setAddressType('p');
		
		userInfo.setUserOtherInfoBean(userOtherInfo);
	    userInfo.setAddressBean(addressBean);
	    

		List<UserAddressBean> userAddressList=new ArrayList<UserAddressBean>();
		userAddressList.add(addressBean);
		userAddressList.add(pAddressBean);
		
		
		
		try {
			ObjectMapper mapper=new ObjectMapper();
			mapper.writerWithDefaultPrettyPrinter();
			mapper.writeValue(new File("empJson4.json"), userInfo);
			mapper.writeValue(System.out, userInfo);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
