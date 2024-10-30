package com.abrar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;

import com.abrar.config.GraphQAslClient;
import com.abrar.dtorecord.Product;

@Service
public class InventoryService implements IInventoryService {

	@Autowired
	private HttpGraphQlClient graphQAslClient;
	
	
	@Override
	public List<Product> viewProducts() {
		
		String getAllProducts="query GetAllProduct {\r\n"
				+ "    getAllProduct {\r\n"
				+ "        name\r\n"
				+ "        category\r\n"
				+ "        price\r\n"
				+ "    }\r\n"
				+ "}";
		
		return graphQAslClient.document(getAllProducts)
				.retrieve("getAllProduct")
				.toEntityList(Product.class)
				.block();
	}


	@Override
	public List<Product> getProductByCategory(String category) {
		
		String getbyCatQuery=String.format("query GetProductByCategory {\r\n"
				+ "    getProductByCategory(category: \"%s\") {\r\n"
				+ "        category\r\n"
				+ "        name\r\n"
				+ "        price\r\n"
				+ "        stock\r\n"
				+ "        id\r\n"
				+ "    }\r\n"
				+ "}",category);
		
		return graphQAslClient.document(getbyCatQuery)
				.retrieve("getProductByCategory")
				.toEntityList(Product.class)
				.block();
	}


	@Override
	public Product updateProduct(int id, int stock) {
		String updateQueary="mutation UpdateStock {\r\n"
				+ "    updateStock(id: \"%d\", stock: %d) {\r\n"
				+ "        id\r\n"
				+ "        name\r\n"
				+ "        category\r\n"
				+ "        price\r\n"
				+ "    }\r\n"
				+ "}";
      		return graphQAslClient.document(updateQueary).retrieve("updateStock").toEntity(Product.class).block();
	}
	
	
}
