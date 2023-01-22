package com.cursprojects.dsdeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cursprojects.dsdeliver.entities.Order;

public interface  OrderRepository extends JpaRepository <Order, Long> {

}
