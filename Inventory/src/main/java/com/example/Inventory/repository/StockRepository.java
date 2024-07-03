package com.example.Inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Inventory.model.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
