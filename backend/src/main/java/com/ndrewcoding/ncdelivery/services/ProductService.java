package com.ndrewcoding.ncdelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndrewcoding.ncdelivery.dto.ProductDTO;
import com.ndrewcoding.ncdelivery.entities.Product;
import com.ndrewcoding.ncdelivery.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<ProductDTO> findAllProducts() {
		List<Product> list = productRepository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
	}
}
