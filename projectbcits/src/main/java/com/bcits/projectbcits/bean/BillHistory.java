package com.bcits.projectbcits.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="table_history")
public class BillHistory implements Serializable{
	@Id
	@Column
	private int meterNumber;
    @Column
	private int units;
    @Column
	private int billAmount;
    @Column
	private String status;
}
