package com.demo.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Customer;
import com.demo.beans.Product;

public class ProductTest {

	public static void main(String[] args) {
		ApplicationContext apx = new ClassPathXmlApplicationContext("spring.xml");
		Product p = (Product) apx.getBean("p1");
		System.out.println(p);
		Customer c =(Customer) apx.getBean("c1");
		System.out.println(c);
		
		Product pp = (Product) apx.getBean("pC");
		System.out.println(pp);
	}

}
