package com.example.Inventory.service;

import com.example.Inventory.model.Order;
import com.example.Inventory.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	public Order updateOrder(Long id, Order order) {
		Order existingOrder = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
		existingOrder.setCustomerName(order.getCustomerName());
		existingOrder.setOrderDate(order.getOrderDate());
		existingOrder.setStatus(order.getStatus());
		return orderRepository.save(existingOrder);
	}

	public void cancelOrder(Long id) {
		Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
		order.setStatus("CANCELLED");
		orderRepository.save(order);
	}
}
