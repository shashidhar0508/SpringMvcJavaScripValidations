package com.test.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.test.model.EmployeeModel;

@Repository
public interface EmployeeDao
{

	public void createEmployee(EmployeeModel employeeModel);

	public List<EmployeeModel> employeeLists();

	public void delEmployee(int id);
	
	public void updateEmployee(EmployeeModel id);
	
	public EmployeeModel getempbyId(int id);

}
