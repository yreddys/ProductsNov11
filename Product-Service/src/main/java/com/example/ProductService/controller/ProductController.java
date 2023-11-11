package com.example.ProductService.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.ProductService.entity.Product;
import com.example.ProductService.exception.productNotFoundException;
import com.example.ProductService.service.ProductService;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/product")
@Log4j2
public class ProductController {
	private ProductService service;

	ProductController(ProductService service) {
		this.service = service;
	}

	@GetMapping("{id}")
	Product getDepartmentById(@PathVariable int id) throws productNotFoundException {
		log.info("Requested Department is {}", id);
		return service.getUpdateById(id);
	}

	@PostMapping("/save")
	String saveProduct(@RequestBody Product product) {
		log.info("Saving product {}", product);
		service.savingProduct(product);
		return "product saved Successfully";
	}

	@PutMapping("/{id}")
	Product updateProductById(@PathVariable int id, @RequestBody Product product) throws productNotFoundException {
		log.info("Requested product is {}", id);
		return service.updateDepartmentById(id, product);
	}

	@DeleteMapping("/{id}")
	String deleteproductById(@PathVariable int id) throws productNotFoundException {
		log.info("Requested Department is {}", id);
		service.deleteproductById(id);
		return "Deeleted Successfully";
	}
}
