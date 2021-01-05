package com.ndrewcoding.ncdelivery.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndrewcoding.ncdelivery.dto.OrderDTO;
import com.ndrewcoding.ncdelivery.entities.Order;
import com.ndrewcoding.ncdelivery.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAllOrders() {
		List<Order> list = orderRepository.findPendingOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
}
