package com.ndrewcoding.ncdelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndrewcoding.ncdelivery.dto.ProductDTO;
import com.ndrewcoding.ncdelivery.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAllProducts() {
		List<ProductDTO> list = productService.findAllProducts();
		return ResponseEntity.ok().body(list);
	}
	
//	@PostMapping
//	public ResponseEntity<ProductDTO> saveProduct() {
//		
//	}
}
