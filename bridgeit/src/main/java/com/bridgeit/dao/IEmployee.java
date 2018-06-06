package com.bridgeit.dao;

import java.util.List;

import com.bridgeit.model.Employee;

public interface IEmployee {
	
	public void saveEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public Employee getEmployee(Employee employee);
	public  List<Employee> list();
		
	
		

}
