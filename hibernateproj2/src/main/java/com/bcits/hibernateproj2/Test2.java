package com.bcits.hibernateproj2.bean.crud;

import java.io.Serializable;
import java.sql.Date;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="employee_primary_info")
public class Test2 implements Serializable{
	@Id
	@Column
  private int EMPID;
	@Column
  private String NAME;

  private long MOBILENO;
	@Column
  private String OFFICIAL_MAILID;
	@Column
  private Date DOB;
	@Column
  private Date DOJ;
	@Column
  private String DESIGNATION;
	@Column
  private String BLOODGROUP;
	@Column
  private double SALARY;
	@Column
  private int DEPTID;
	@Column
  private int MANAGERID;
	@Column
public int getEMPID() {
	return EMPID;
}
public void setEMPID(int eMPID) {
	EMPID = eMPID;
}
public String getNAME() {
	return NAME;
}
public void setNAME(String nAME) {
	NAME = nAME;
}
public long getMOBILENO() {
	return MOBILENO;
}
public void setMOBILENO(long mOBILENO) {
	MOBILENO = mOBILENO;
}
public String getOFFICIAL_MAILID() {
	return OFFICIAL_MAILID;
}
public void setOFFICIAL_MAILID(String oFFICIAL_MAILID) {
	OFFICIAL_MAILID = oFFICIAL_MAILID;
}
public Date getDOB() {
	return DOB;
}
public void setDOB(Date dOB) {
	DOB = dOB;
}
public Date getDOJ() {
	return DOJ;
}
public void setDOJ(Date dOJ) {
	DOJ = dOJ;
}
public String getDESIGNATION() {
	return DESIGNATION;
}
public void setDESIGNATION(String dESIGNATION) {
	DESIGNATION = dESIGNATION;
}
public String getBLOODGROUP() {
	return BLOODGROUP;
}
public void setBLOODGROUP(String bLOODGROUP) {
	BLOODGROUP = bLOODGROUP;
}
public double getSALARY() {
	return SALARY;
}
public void setSALARY(double sALARY) {
	SALARY = sALARY;
}
public int getDEPTID() {
	return DEPTID;
}
public void setDEPTID(int dEPTID) {
	DEPTID = dEPTID;
}
public int getMANAGERID() {
	return MANAGERID;
}
public void setMANAGERID(int mANAGERID) {
	MANAGERID = mANAGERID;
}
}
