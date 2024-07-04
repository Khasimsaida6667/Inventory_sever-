package com.example.Inventory.controller;

import com.example.Inventory.model.Stock;
import com.example.Inventory.model.Order;
import com.example.Inventory.model.Supplier;
import com.example.Inventory.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/report")
@CrossOrigin(origins = "http://localhost:3000")
public class ReportController {
	@Autowired
	private ReportService reportService;

	@GetMapping("/stock")
	public List<Stock> generateStockReport() {
		return reportService.generateStockReport();
	}

	@GetMapping("/order")
	public List<Order> generateOrderReport() {
		return reportService.generateOrderReport();
	}

	@GetMapping("/supplier")
	public List<Supplier> generateSupplierReport() {
		return reportService.generateSupplierReport();
	}
}