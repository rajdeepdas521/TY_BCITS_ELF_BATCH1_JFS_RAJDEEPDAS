package com.bcits.projectbcits.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="monthly_consumption")
public class MonthlyConsumption implements Serializable{
    @Id
    @Column
	private int meterNumber;
    @Column
	private long initialReading;
    @Column
	private long finalReading;
    @Column
	private int totalUnit;
    @Column
    private double billAmount;
}
