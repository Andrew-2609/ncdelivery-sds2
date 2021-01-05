package com.ndrewcoding.ncdelivery.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ndrewcoding.ncdelivery.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
