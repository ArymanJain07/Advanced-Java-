package com.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Employee;

public class TestCollection {

	public static void main(String[] args) {
		ApplicationContext apx = new ClassPathXmlApplicationContext("spring.xml");
		Employee emp = (Employee) apx.getBean("emp");
		Employee emp2 = (Employee) apx.getBean("emp2");
		System.out.println(emp);
		System.out.println(emp2);
		
	}

}
