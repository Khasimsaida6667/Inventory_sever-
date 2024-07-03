package com.example.Inventory.service;

import com.example.Inventory.model.Stock;
import com.example.Inventory.model.Order;
import com.example.Inventory.model.Supplier;
import com.example.Inventory.repository.StockRepository;
import com.example.Inventory.repository.OrderRepository;
import com.example.Inventory.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {
 @Autowired
 private StockRepository stockRepository;
 @Autowired
 private OrderRepository orderRepository;
 @Autowired
 private SupplierRepository supplierRepository;

 public List<Stock> generateStockReport() {
     return stockRepository.findAll();
 }

 public List<Order> generateOrderReport() {
     return orderRepository.findAll();
 }

 public List<Supplier> generateSupplierReport() {
     return supplierRepository.findAll();
 }
}