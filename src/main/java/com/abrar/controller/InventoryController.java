package com.abrar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abrar.dtorecord.Product;
import com.abrar.service.IInventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private IInventoryService iInventoryService;

	@GetMapping("/getAllProduct")
	public List<Product> getAllProducts() {
		return iInventoryService.viewProducts();
	}
	
	
	@GetMapping("/getProductCategory/{category}")
	public List<Product> getProductByCategory(@PathVariable String category)
	{
		return iInventoryService.getProductByCategory(category);
	}
	
	@PutMapping("/updateProduct/{id}/{stock}")
	public Product updateProduct(@PathVariable int id, @PathVariable int stock)
	{
		return iInventoryService.updateProduct(id, stock);
	}

}
