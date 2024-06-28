package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addNewProduct();

	boolean deleteById(int pid);

	List<Product> displayAll();

	Product findById(int pid);

	boolean modifyProduct(int pid, String pname, int qty, int price);

	List<Product> getByqty(int qty);

	List<Product> getSortedById();

}
