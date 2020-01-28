package com.bcits.springrestjaxb.beans;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;

@Data
@XmlRootElement(name = "Employee-info")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("employeeInfo")
@JsonPropertyOrder({"empId","name","salary"})
public class EmployeeInfoBean {

	@XmlElement(name="employee-id")
//	@XmlAttribute(name = "emp-id")
	@JsonProperty("employeeID")
	private int empId;
	@XmlElement
//	@XmlAttribute
	private String name;
	@JsonProperty("departmentID")
	@XmlElement(name = "department-id")
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
	@XmlElement
//	@XmlTransient               to avoid binding 
	@JsonIgnore
	private String password;

}
