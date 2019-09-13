package com.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EmployeeDetails")
public class EmployeeModel 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id")
	private int empId;
		
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_pass")
	private String empPass;
	
	@Column(name="emp_cf_pass")
	private String empCfPass;
	
	@Column(name="emp_phno")
	private String empPhno;
	
	@Column(name="emp_age")
	private String empAge;
	
	@Column(name="emp_addr")
	private String empAddr;
	
	@Column(name="emp_gend")
	private String empGender;
	
	@Column(name="emp_dob")
	private String empDob;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpPass() {
		return empPass;
	}
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}
	public String getEmpCfPass() {
		return empCfPass;
	}
	public void setEmpCfPass(String empCfPass) {
		this.empCfPass = empCfPass;
	}
	public String getEmpPhno() {
		return empPhno;
	}
	public void setEmpPhno(String empPhno) {
		this.empPhno = empPhno;
	}
	public String getEmpAge() {
		return empAge;
	}
	public void setEmpAge(String empAge) {
		this.empAge = empAge;
	}
	public String getEmpAddr() {
		return empAddr;
	}
	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public EmployeeModel(int empId, String empName, String empPass, String empCfPass, String empPhno, String empAge,
			String empAddr, String empGender) 
	{
		super();
		this.empId = empId;
		this.empName = empName;
		this.empPass = empPass;
		this.empCfPass = empCfPass;
		this.empPhno = empPhno;
		this.empAge = empAge;
		this.empAddr = empAddr;
		this.empGender = empGender;
	}
	public EmployeeModel() 
	{
		
	}
	public String getEmpDob() {
		return empDob;
	}
	public void setEmpDob(String empDob) {
		this.empDob = empDob;
	}
}
