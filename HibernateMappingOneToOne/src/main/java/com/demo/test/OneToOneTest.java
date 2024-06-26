package com.demo.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.demo.beans.Laptop;
import com.demo.beans.Student;

public class OneToOneTest {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		SessionFactory sf = con.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction tr = sess.beginTransaction();
		Laptop lap = new Laptop(101,"hp");
		Student stu = new Student(1,"aryman",lap);
		
		sess.save(stu);
		sess.save(lap);
		
		tr.commit();
		sess.close();
		
	}

}
