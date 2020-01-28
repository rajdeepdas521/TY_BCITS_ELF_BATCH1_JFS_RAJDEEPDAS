package com.bcits.springrestjaxb.beans;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;
import org.omg.CORBA.PRIVATE_MEMBER;

import lombok.Data;

@Data
@XmlRootElement(name = "user-info")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("userInfo")
public class UserInfoBean {

//	@XmlElement(name="employee-id")
	@XmlAttribute(name = "user-id")
	@JsonProperty("employeeId")
	private int empId;
//	@XmlElement
	@XmlAttribute
	private String name;
	@XmlElement(name = "department-id")
	@JsonProperty("departmentId")
	private int deptId;
	@XmlElement
	private String designation;
	@XmlElement
	private Date joiningDate;
	@XmlElement
	private long mobile;
	@XmlElement
	private String officialmailId;
	@XmlElement
	private Date dob;
	@XmlElement
	private String bloodgroup;
	@XmlElement
	private double salary;
	@XmlElement
	private int managerId;
//	@XmlElement
	@XmlTransient // to avoid binding
	private String password;

	@XmlElement(name = "user-other-info")
	private UserOtherInfoBean userOtherInfoBean;
	@XmlElement(name="user-address-list")
	private UserAddressBean  addressBean;

	
	  @XmlElementWrapper(name = "user-address-list")
	  private List<UserAddressBean> userAddressList;
	 
}
