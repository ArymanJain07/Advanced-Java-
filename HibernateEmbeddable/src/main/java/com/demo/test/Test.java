package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.Employee.Address;
import com.demo.Employee.Employee;

public class Test {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Employee.class);
		SessionFactory sf = con.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Address add = new Address("vigyan","bhawaPark","kota");
		//Employee e1 = new Employee(1,"aryman",add);
		
		//sess.save(e1);
		Employee e2 = sess.get(Employee.class, 1);
		System.out.println(e2);
		
		tr.commit();
		
	}

}
