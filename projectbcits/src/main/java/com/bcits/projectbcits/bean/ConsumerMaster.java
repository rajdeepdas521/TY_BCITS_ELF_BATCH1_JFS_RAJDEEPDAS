package com.bcits.projectbcits.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "consumers_master")
public class ConsumerMaster implements Serializable{
	@Id
	@Column
    private int meterNumber;
	
	@Column
    private String name;
	
	@Column(name="phone_number")
    private long mobilenum;
	
	@Column(name="mail_id")
    private String mailId;
	@Column
	private String address;
	
	@Column
	private String region;
	
	@Column
    private String password;
	
	/*
	 * @Column private String confirmPassword;
	 */
	
    
    
}
