package com.ndrewcoding.ncdelivery.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

	@PostMapping
	public ResponseEntity<OrderDTO> insertOrder(@RequestBody OrderDTO orderDto) {
		orderDto = orderService.insertOrder(orderDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id").buildAndExpand(orderDto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(orderDto);
	}
}
