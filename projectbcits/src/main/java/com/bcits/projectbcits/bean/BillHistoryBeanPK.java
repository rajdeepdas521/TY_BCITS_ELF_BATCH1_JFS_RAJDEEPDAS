package com.bcits.projectbcits.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

import lombok.Data;
@Data
@Embeddable
public class BillHistoryBeanPK implements Serializable{
    
	@Column
	private int meterNumber;
	@Column
	private Date dueDate;
}
