package com.test.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.test.model.EmployeeModel;

@Repository
public class EmployeeDaoImpl implements EmployeeDao 
{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Transactional
	@Override
	public void createEmployee(EmployeeModel employeeModel)
	{
		hibernateTemplate.save(employeeModel);
	}

	@Override
	public List<EmployeeModel> employeeLists() 
	{
		return hibernateTemplate.loadAll(EmployeeModel.class);
	}

	@Transactional
	public void delEmployee( int id)
	{
		EmployeeModel employeeModel=hibernateTemplate.get(EmployeeModel.class, id);
		System.out.println("delete"+employeeModel);
		hibernateTemplate.delete(employeeModel);
	}
	
	@Transactional
	public void updateEmployee(EmployeeModel id)
	{
		hibernateTemplate.update(id);		
	}

	@Override
	public EmployeeModel getempbyId(int id)
	{
		EmployeeModel employeeModel=hibernateTemplate.get(EmployeeModel.class, id);		
		return employeeModel;
	}
}
