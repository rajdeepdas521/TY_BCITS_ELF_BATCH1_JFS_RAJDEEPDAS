package com.bcits.projectbcits.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import lombok.Data;
@Data
@Embeddable
public class TarrifMasterPk implements Serializable{

	
	@Column
	private String consumerType;
	@Column
	private int range;
}
