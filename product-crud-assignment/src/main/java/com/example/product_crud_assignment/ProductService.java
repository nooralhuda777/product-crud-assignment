package com.example.product_crud_assignment;

import java.util.List;

public interface ProductService {
  public Product createProduct(Product product);
   public List<Product> getAllProducts();
   public Product getProductById(Long id);
   public Product updateProduct(Long id, Product updatedProduct);
   public void deleteProduct(Long id);
}
