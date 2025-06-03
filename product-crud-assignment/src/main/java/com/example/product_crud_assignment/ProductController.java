package com.example.product_crud_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  
@Autowired
private ProductServiceImpl productService;
public ProductController(ProductServiceImpl productService) {
    this.productService = productService;
}



 // Create
 @PostMapping
 public Product createProduct(@RequestBody Product product) {
     Product newProduct = productService.createProduct(product);
     return newProduct;
 }

 // Read all
 @GetMapping
 public List<Product> getAllProducts() {
     List<Product> allProducts = productService.getAllProducts();
     return allProducts;
 }

 // Read by ID
 @GetMapping("/{id}")
 public Product getProductById(@PathVariable Long id) {
    Product product = productService.getProductById(id);
    return product;
 }

 // Update
 @PutMapping("/{id}")
 public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
    Product updateProduct = productService.updateProduct(id, product);
    return updateProduct;
 }

 // Delete
 @DeleteMapping("/{id}")
 public void deleteProduct(@PathVariable Long id) {
     productService.deleteProduct(id);
 }
}