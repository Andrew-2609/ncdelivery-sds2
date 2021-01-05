package com.ndrewcoding.ncdelivery.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ndrewcoding.ncdelivery.dto.OrderDTO;
import com.ndrewcoding.ncdelivery.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAllOrders() {
		List<OrderDTO> list = orderService.findAllOrders();
		return ResponseEntity.ok().body(list);
	}
}
