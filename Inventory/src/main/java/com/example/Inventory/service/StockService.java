package com.example.Inventory.service;

import com.example.Inventory.model.Stock;
import com.example.Inventory.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
 @Autowired
 private StockRepository stockRepository;

 public List<Stock> getAllStocks() {
     return stockRepository.findAll();
 }

 public Stock addStock(Stock stock) {
     return stockRepository.save(stock);
 }

 public Stock updateStock(Long id, Stock stock) {
     Stock existingStock = stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found"));
     existingStock.setItemName(stock.getItemName());
     existingStock.setQuantity(stock.getQuantity());
     existingStock.setPrice(stock.getPrice());
     return stockRepository.save(existingStock);
 }

 public void deleteStock(Long id) {
     stockRepository.deleteById(id);
 }
}