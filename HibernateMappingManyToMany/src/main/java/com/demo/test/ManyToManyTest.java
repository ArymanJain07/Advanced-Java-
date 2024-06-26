package com.demo.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Laptop;
import com.demo.beans.Student;

public class ManyToManyTest {

	public static void main(String[] args) {
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		
		Laptop lap1 = new Laptop(1,"del",null);
		Laptop lap2 = new Laptop(2,"mac",null);
		Laptop lap3 = new Laptop(3,"hp",null);
		Laptop lap4 = new Laptop(4,"lenovo",null);
		List<Laptop> lList = new ArrayList<Laptop>();
		
		lList.add(lap1);
		lList.add(lap2);
		lList.add(lap3);
		lList.add(lap4);
		
		Student stu1 = new Student(101,"Aryman",lList);
		Student stu2 = new Student(102,"dhruv",lList);
		Student stu3 = new Student(103,"anurag",lList);
		Student stu4 = new Student(104,"ankit",lList);
		List<Student> sList = new ArrayList<Student>();
		
		lap1 = new Laptop(1,"del",sList);
		lap2 = new Laptop(2,"mac",sList);
		lap3 = new Laptop(3,"hp",sList);
		lap4 = new Laptop(4,"lenovo",sList);
		
		session.save(stu1);
		session.save(stu2);
		session.save(stu3);
		session.save(stu4);
		
		session.save(lap1);
		session.save(lap2);
		session.save(lap3);
		session.save(lap4);
		
		      
		tr.commit();
		session.close();
		
		
	}

}
