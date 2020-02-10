package com.bcits.projectbcits.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
@Embeddable
public class MonthlyConsumptionPk implements Serializable{

	@Column
	private int meterNumber;
    @Column
    private Date date;

}
