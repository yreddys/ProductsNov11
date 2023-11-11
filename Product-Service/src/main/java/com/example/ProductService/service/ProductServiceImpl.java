package com.example.ProductService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductService.entity.Product;
import com.example.ProductService.exception.productNotFoundException;
import com.example.ProductService.repository.ProductRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ProductServiceImpl implements ProductService {

	private ProductRepository repo;

	@Autowired
	ProductServiceImpl(ProductRepository repo) {

		this.repo = repo;
	}

	@Override
	public Product savingProduct(Product product) {

		log.info("Saving product {}", product);

		// Save the product
		Product savedProduct = repo.save(product);

		log.info("Saved product {}", savedProduct);

		return savedProduct;
	}

	@Override

	public Product updateDepartmentById(int id, Product product) throws productNotFoundException {
		Optional<Product> optionalProduct = repo.findById(id);

		if (optionalProduct.isPresent()) {
			Product existingProduct = optionalProduct.get();

			// Assuming you have appropriate setters in the Product class
			existingProduct.setProductName(product.getProductName());
			existingProduct.setDescription(product.getDescription());
			existingProduct.setPrice(product.getPrice());
			existingProduct.setStatus(product.getStatus());

			// Save the updated product
			Product updatedProduct = repo.save(existingProduct);

			log.info("Updated Product: {}", updatedProduct);
			return updatedProduct;
		} else {
			String errorMessage = "Product with ID " + id + " not found. Update aborted.";
			log.warn(errorMessage);
			throw new productNotFoundException(errorMessage);
		}
	}

	

	@Override
	public void deleteproductById(int id) throws productNotFoundException {
		Optional<Product> optionalDepartment = repo.findById(id);
		if (optionalDepartment.isPresent()) {
			Product existingDepartment = optionalDepartment.get();
			repo.delete(existingDepartment);
			log.info("product with ID {} deleted successfully.", id);

		} else {
			String errorMessage = "Product with ID " + id + " not found. Deletion aborted.";
			log.warn(errorMessage);
			throw new productNotFoundException(errorMessage);
		}

	}

	@Override
	public Product getUpdateById(int id) throws productNotFoundException {
		log.info("Fetching department by ID: {}", id);

		Optional<Product> departmentOptional = repo.findById(id);

		log.info("Fetching product by ID: {}", id);

		Optional<Product> productOptional = repo.findById(id);

		if (productOptional.isPresent()) {
			Product product = productOptional.get();
			log.info("Product found: {}", product);
			return product;
		} else {
			String errorMessage = "Product with ID " + id + " not found.";
			log.warn(errorMessage);
			throw new productNotFoundException(errorMessage);
		}

	}

	
}
