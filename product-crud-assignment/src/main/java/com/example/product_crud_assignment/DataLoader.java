package com.example.product_crud_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
@Component
public class DataLoader {
private ProductRepository productRepository;

@Autowired
public DataLoader(ProductRepository productRepository) {
  this.productRepository = productRepository;
}

@PostConstruct
public void loadData(){
  productRepository.deleteAll();
  //load new data
  productRepository.save(new Product("Laptop", 1000, 5));
  productRepository.save(new Product("Smartphone", 800, 10));
  productRepository.save(new Product("Tablet", 600, 8));
}
}
