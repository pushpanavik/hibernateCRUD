package com.bridgeit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.bridgeit.model.Employee;

public class EmployeeDaoImpl implements IEmployee {
	@Autowired
	private  SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		System.out.println("stores an object reference in session factory");
		this.sessionFactory=sessionFactory;
		System.out.println(this.sessionFactory);
	}
	


	public void saveEmployee(Employee employee) {
		
		Session session=this.sessionFactory.openSession();
		System.out.println("open session ");
		Transaction t=session.beginTransaction();
		System.out.println("transaction begins");
		session.save(employee);
		t.commit();
		System.out.println("transaction is saved and commited in the database ");
		session.close();
	}

	@SuppressWarnings("unchecked")
	public List<Employee> list() {
		Session session=this.sessionFactory.openSession();
		List<Employee> e=session.createCriteria(Employee.class).list();
		session.getTransaction();
		
		session.close();
		return e;
	}

	public void deleteEmployee(Employee employee) {
		Session session=this.sessionFactory.openSession();
		System.out.println("entered in delete method");
		Transaction tx=session.beginTransaction();
		
		String query="from Employee where  Emp_ID=:Emp_ID";
		Query q=session.createQuery(query);
		
		q.setInteger("Emp_ID",3);
		Employee e=(Employee)q.uniqueResult(); 
		session.delete(e);
		System.out.println("employee record successfully deleted  "+e);
		session.getTransaction();
		tx.commit();
		session.close();	
	}

	public void updateEmployee(Employee employee) {
		Session session=this.sessionFactory.openSession();
		System.out.println("entered in update method");
		Transaction tx=session.beginTransaction();
		
		Employee e=(Employee) session.get(Employee.class, 5);
		e.setEmp_Name("Shyam Jaiswal");
		session.update(e);
		System.out.println("successfully updated record  "+e);
		session.getTransaction();
		tx.commit();
		session.close();
		
	}

	public Employee getEmployee(Employee employee) {
		Session session=this.sessionFactory.openSession();
		System.out.println("entered into employee specific details");
		Transaction t=session.beginTransaction();
			
		Employee e=(Employee) session.get(Employee.class, 7);
		session.update(e);
		System.out.println("Employee Id" +e.getEmp_ID());
		System.out.println("Employee name" + e.getEmp_Name());
		t.commit();
		session.close();
		return e;
	}
	
	

}
