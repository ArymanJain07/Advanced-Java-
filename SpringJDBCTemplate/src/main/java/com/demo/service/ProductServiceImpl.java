package com.demo.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao pDao; 
	
	Scanner sc = new Scanner(System.in);
	
	public void addNewProduct() {
		System.out.println("Enter the product Id:");
		int pid = sc.nextInt();
		System.out.println("Enter the product name");
		String pname = sc.next();
		System.out.println("Enter the Product qty");
		int qty = sc.nextInt();
		System.out.println("Enter the product Price");
		int price = sc.nextInt();
	
		Product p = new Product (pid,pname,qty,price);
		
		pDao.save(p);
	}

	public boolean deleteById(int pid) {
		
		return pDao.removeById(pid);
	}

	@Override
	public List<Product> displayAll() {
		
		return pDao.findAll();
	}

	@Override
	public Product findById(int pid) {
		
		return pDao.searchById(pid);
	}

	@Override
	public boolean modifyProduct(int pid, String pname, int qty, int price) {
		
		return pDao.updateProduct(pid,pname,qty,price);
	}

	@Override
	public List<Product> getByqty(int qty) {
		return pDao.searchByQty(qty);
	}

	@Override
	public List<Product> getSortedById() {
		
		return pDao.sortbyid();
	}

	
}
