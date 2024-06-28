package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.beans.Product;
import com.demo.service.ProductService;

public class ProductJDBCTemplateTest {

	public static void main(String[] args) {
		
		ApplicationContext apx = new ClassPathXmlApplicationContext("spring.xml");
		ProductService pService = (ProductService) apx.getBean("productServiceImpl");
		
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1. add new product\n 2. delete product \n 3. modify product");
			System.out.println("4. display all\n 5. display by id\n6. display by qty");
			System.out.println("7. display in sorted order\n 8. exit\n choice: ");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				pService.addNewProduct();
				break;
			case 2:
				System.out.println("Enter id to delete :");
				int pid = sc.nextInt(); 
				boolean status = pService.deleteById(pid);
				if(status) {
					System.out.println("Value Deleted Successfully ");
				}else {
					System.out.println("Error Occured or id not found");
				}
				break;
			case 3:
				System.out.println("Enter pid to upate Value");
				pid = sc.nextInt();
				System.out.println("Enter the pname ");
				String pname = sc.next();
				System.out.println("Enter the Qty");
				int qty = sc.nextInt();
				System.out.println("Enetr the price ");
				int price = sc.nextInt();
				
				status = pService.modifyProduct(pid,pname,qty,price);
				
				if(status) {
					System.out.println("uspdate successfully");
					
				}else {
					System.out.println("Not Found");
				}
				
				break;
			case 4:
				List<Product> pList = pService.displayAll();
				
				if(pList.isEmpty()) {
					System.out.println("Operation Fail james bond007");
				}else {
					pList.forEach(System.out::println);
				}
				break;
			case 5:
				System.out.println("Enter Id to search ");
				pid = sc.nextInt();
				Product p = pService.findById(pid);
				if(p!=null) {
					System.out.println(p);
				}else {
					System.out.println("Not found");
				}
				break;
			case 6:
				System.out.println("enter the Qty");
				qty = sc.nextInt();
				pList=pService.getByqty(qty);
				pList.forEach(System.out::println);
				break;
			case 7:
				pList=pService.getSortedById();
				pList.forEach(System.out::println);
				
				break;
			case 8:
				((ClassPathXmlApplicationContext)apx).close();
				sc.close();
				System.out.println("Thankyou visitintg");
				break;
			
			
			}
		} while (choice != 8);
		
		
	}

}
