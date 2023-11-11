package com.example.ProductService.service;

import com.example.ProductService.entity.Product;
import com.example.ProductService.exception.productNotFoundException;

public interface ProductService {

	Product savingProduct(Product product);

	Product updateDepartmentById(int id, Product product) throws productNotFoundException;

	void deleteproductById(int id) throws productNotFoundException;

	Product getUpdateById(int id) throws productNotFoundException;

}
