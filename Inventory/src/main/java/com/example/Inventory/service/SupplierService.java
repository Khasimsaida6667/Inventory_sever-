package com.example.Inventory.service;

import com.example.Inventory.model.Supplier;
import com.example.Inventory.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {
 @Autowired
 private SupplierRepository supplierRepository;

 public List<Supplier> getAllSuppliers() {
     return supplierRepository.findAll();
 }

 public Supplier addSupplier(Supplier supplier) {
     return supplierRepository.save(supplier);
 }

 public Supplier updateSupplier(Long id, Supplier supplier) {
     Supplier existingSupplier = supplierRepository.findById(id).orElseThrow(() -> new RuntimeException("Supplier not found"));
     existingSupplier.setName(supplier.getName());
     existingSupplier.setContactInfo(supplier.getContactInfo());
     return supplierRepository.save(existingSupplier);
 }

 public void deleteSupplier(Long id) {
     supplierRepository.deleteById(id);
 }
}