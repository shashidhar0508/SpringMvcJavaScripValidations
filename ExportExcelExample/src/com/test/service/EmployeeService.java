package com.test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.EmployeeDao;
import com.test.model.EmployeeModel;

@Service
public class EmployeeService
{
	@Autowired
	private EmployeeDao employeeDao;

	public void addEmployee(EmployeeModel employeeModel)
	{
		
		 employeeDao.createEmployee(employeeModel);
	}
	
	public List<EmployeeModel> employeeList()
	{
		return employeeDao.employeeLists(); 
	}
	
	public void delEmployee(int id)
	{
		employeeDao.delEmployee(id);
	}
	
	public void updateEmployee(EmployeeModel id)
	{
		employeeDao.updateEmployee(id);
	}
	public EmployeeModel getempbyId(int id)
	{
		return employeeDao.getempbyId(id);
	}

}
