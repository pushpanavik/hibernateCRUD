package com.bridgeit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@Column(name="Emp_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
		private int Emp_ID;
	private String Emp_Name;
	public int getEmp_ID() {
		return Emp_ID;
	}
	public void setEmp_ID(int emp_ID) {
		Emp_ID = emp_ID;
	}
	public String getEmp_Name() {
		return Emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		Emp_Name = emp_Name;
	}
	public Employee() {
	
		System.out.println("default constructor called" );
		
	}
	public Employee(int emp_ID, String emp_Name) {
		
		System.out.println("parameterized constructor values referred");
		Emp_ID = emp_ID;
		Emp_Name = emp_Name;
	}
	@Override
	public String toString() {
		return "Employee [Emp_ID=" + Emp_ID + ", Emp_Name=" + Emp_Name + "]";
	}
	
	
}
