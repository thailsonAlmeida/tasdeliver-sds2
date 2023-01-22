package com.cursprojects.dsdeliver.service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cursprojects.dsdeliver.dto.OrderDTO;
import com.cursprojects.dsdeliver.dto.ProductDTO;
import com.cursprojects.dsdeliver.entities.Order;
import com.cursprojects.dsdeliver.entities.OrderStatus;
import com.cursprojects.dsdeliver.entities.Product;
import com.cursprojects.dsdeliver.repositories.OrderRepository;
import com.cursprojects.dsdeliver.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrderWithProducts();
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(), dto.getLongitude(),
				Instant.now(), OrderStatus.PENDING);
		/*copyDtoToEntity(dto, entity);*/
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getReferenceById(p.getId());
			order.getProducts().add(product);
		}
		order = repository.save(order);
		return new OrderDTO(order);
	}
/*
	private void copyDtoToEntity(OrderDTO dto, Order entity) {
		entity.setAddress(dto.getAddress());
		entity.setLatitude(dto.getLatitude());
		entity.setLongitude(dto.getLongitude());
		entity.setMoment(Instant.now());
		entity.setStatus(OrderStatus.PENDING);
		
		entity.getProducts().clear();
		
		for (ProductDTO p : dto.getProducts()) {
			Product product = productRepository.getReferenceById(p.getId());
			entity.getProducts().add(product);
		}
	}*/
}
