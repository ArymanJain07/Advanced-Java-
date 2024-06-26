package com.demo.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Laptop;
import com.demo.beans.Student;

public class ManyToOneTest {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Laptop lap = new Laptop(4,"del");
		Laptop lap2 = new Laptop(5,"mac");
		
		List<Laptop> lList = new ArrayList<Laptop>();
		lList.add(lap);
		lList.add(lap2);
		Student stu = new Student(3,"dhruv",lList);
		
		session.save(stu);
		session.save(lap);
		session.save(lap2);
		
		
		
		

		
		tr.commit();
		session.close();
	
	
	
	
	}

}
