package com.bcits.springrestjaxb.beans;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

import lombok.Data;

@Data
@XmlRootElement(name="user-address")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("addressInfo")
public class UserAddressBean {
	
	@XmlElement(name="house-number")
	@JsonProperty("houseNumber")
	private int houseNum;
	@XmlElement
	private String street;
	@XmlElement
	private String city;
	@XmlElement(name="address-type")
	private char addressType;

}
