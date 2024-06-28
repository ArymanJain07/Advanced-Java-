package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {


	void save(Product p);

	boolean removeById(int pid);

	List<Product> findAll();

	Product searchById(int pid);

	boolean updateProduct(int pid, String pname, int qty, int price);

	List<Product> searchByQty(int qty);

	List<Product> sortbyid();
	
	
	
}
