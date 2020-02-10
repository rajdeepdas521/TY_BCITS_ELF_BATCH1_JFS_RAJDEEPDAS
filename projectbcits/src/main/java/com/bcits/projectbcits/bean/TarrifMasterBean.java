package com.bcits.projectbcits.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tarrif_Master")
public class TarrifMasterBean implements Serializable {

	@EmbeddedId
	private TarrifMasterPk tarrifMasterPk;
	@Column
	private int amount;

}
