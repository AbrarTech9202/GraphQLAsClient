package com.abrar.service;

import java.util.List;

import com.abrar.dtorecord.Product;

public interface IInventoryService {
	
	public List<Product> viewProducts();
	
	public List<Product> getProductByCategory(String category);
	
	public Product updateProduct(int id ,int stock);

}
