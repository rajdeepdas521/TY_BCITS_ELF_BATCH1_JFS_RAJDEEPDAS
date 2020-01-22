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
@Table(name="current_bill")
public class CurrentBill implements Serializable{
  @Id
  @Column
	private int meterNumber;
  
  @Column
  private int consuptionUnits;
  
  @Column
  private double billAmount;
  
  @Column
  private double dueAmount;
  
  @Column
  private Date dueDate;
 
}
