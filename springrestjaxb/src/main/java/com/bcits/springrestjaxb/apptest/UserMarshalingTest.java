package com.bcits.springrestjaxb.apptest;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.bcits.springrestjaxb.beans.EmployeeInfoBean;
import com.bcits.springrestjaxb.beans.UserAddressBean;
import com.bcits.springrestjaxb.beans.UserInfoBean;
import com.bcits.springrestjaxb.beans.UserOtherInfoBean;

public class UserMarshalingTest {

	public static void main(String[] args) {
		
		UserInfoBean userInfo =new UserInfoBean();
		userInfo.setEmpId(9999);
		userInfo.setDeptId(22);
		userInfo.setBloodgroup("B+");
		userInfo.setDesignation("SSD");
		userInfo.setDob(new Date());
		userInfo.setJoiningDate(new Date());
		userInfo.setManagerId(20);
		userInfo.setMobile(8986826174L);
		userInfo.setName("Rajdeep Das");
		userInfo.setOfficialmailId("rajdeep@gmail.com");
		userInfo.setSalary(99999);
		
		UserOtherInfoBean userOtherInfo =new UserOtherInfoBean();
		userOtherInfo.setGender("Male");
		userOtherInfo.setAadharNumber(123456789L);
		
		userInfo.setUserOtherInfoBean(userOtherInfo);
		
		
		UserAddressBean tempAddressInfo=new UserAddressBean();
		tempAddressInfo.setHouseNum(1);
		tempAddressInfo.setStreet("abc street");
		tempAddressInfo.setCity("BLR");
		tempAddressInfo.setAddressType('t');
		
		UserAddressBean pAddressBean=new UserAddressBean();
		pAddressBean.setHouseNum(5);
		pAddressBean.setStreet("XYZ street");
		pAddressBean.setCity("HYD");
		pAddressBean.setAddressType('p');
		
		List<UserAddressBean> userAddressList=new ArrayList<UserAddressBean>();
		userAddressList.add(pAddressBean);
		userAddressList.add(tempAddressInfo);
		
		/* userInfo.setUserAddressList(userAddressList); */
		
		

		try {
			JAXBContext context=JAXBContext.newInstance(UserInfoBean.class);
			Marshaller marshaller=context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			marshaller.marshal(userInfo, System.out);
			marshaller.marshal(userInfo, new File("userInfo1.xml"));
		} catch (JAXBException e) {
			
			e.printStackTrace();
			System.err.println("Unable To Marshall!!!!");
		}

	}

}
