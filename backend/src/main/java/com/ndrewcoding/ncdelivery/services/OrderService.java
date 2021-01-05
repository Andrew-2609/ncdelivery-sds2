package com.ndrewcoding.ncdelivery.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ndrewcoding.ncdelivery.dto.OrderDTO;
import com.ndrewcoding.ncdelivery.dto.ProductDTO;
import com.ndrewcoding.ncdelivery.entities.Order;
import com.ndrewcoding.ncdelivery.entities.OrderStatus;
import com.ndrewcoding.ncdelivery.entities.Product;
import com.ndrewcoding.ncdelivery.repositories.OrderRepository;
import com.ndrewcoding.ncdelivery.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Transactional(readOnly = true)
	public List<OrderDTO> findAllOrders() {
		List<Order> list = orderRepository.findPendingOrdersWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}

	@Transactional
	public OrderDTO insertOrder(OrderDTO orderDto) {
		Order order = new Order(null, orderDto.getAddress(), orderDto.getLatitude(), orderDto.getLongitude(),
				Instant.now(), OrderStatus.PENDING);
		for (ProductDTO productDto : orderDto.getProducts()) {
			Product product = productRepository.getOne(productDto.getId());
			order.getProducts().add(product);
		}

		order = orderRepository.save(order);

		return new OrderDTO(order);
	}

	@Transactional
	public OrderDTO setOrderDelivered(Long id) {
		Order order = orderRepository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = orderRepository.save(order);
		return new OrderDTO(order);
	}
}
