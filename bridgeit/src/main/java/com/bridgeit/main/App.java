package com.bridgeit.main;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bridgeit.dao.EmployeeDaoImpl;
import com.bridgeit.dao.IEmployee;
import com.bridgeit.model.Employee;

/**
 * Hello world!
 *
 */
public class App {
		
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		 IEmployee empI = (IEmployee) context.getBean("IEmployee", EmployeeDaoImpl.class);
		 
		 Employee employee=new Employee();
		 employee.setEmp_Name("priya");
		 empI.saveEmployee(employee);
		 System.out.println("Employee added" +employee);
		 
		 empI.updateEmployee(employee);
		 empI.deleteEmployee(employee);
		 empI.getEmployee(employee);
		 
		 List<Employee> list = empI.list();
		 System.out.println(6);
		 for (Employee e : list)
		 {
			System.out.println("Employee List ::" + e);
		 }
		 System.out.println(5);
			
		 empI.list();
		}
	}
	
	

