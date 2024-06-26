package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Employee;

public class Test {

	public static void main(String[] args) {
		
		//Employee e1;
		//Employee e2= null;
		
		
		Configuration con = new Configuration().configure().addAnnotatedClass(com.demo.beans.Employee.class);
		
		SessionFactory sf = con.buildSessionFactory(); 
		Session session = sf.openSession();
		
		
		Transaction tr = session.beginTransaction();
		
		Employee e3 = session.get(Employee.class, 101);
		System.out.println(e3.getId()+"---"+e3.getName()+"---"+e3.getDept());
		System.out.println(e3);
		//session.save(e1);
		//session.save(e2);
		tr.commit();
		
		
		
	}

}
