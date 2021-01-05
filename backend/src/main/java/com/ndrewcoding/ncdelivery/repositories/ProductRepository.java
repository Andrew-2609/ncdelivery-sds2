package com.ndrewcoding.ncdelivery.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ndrewcoding.ncdelivery.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAllByOrderByNameAsc();
}
