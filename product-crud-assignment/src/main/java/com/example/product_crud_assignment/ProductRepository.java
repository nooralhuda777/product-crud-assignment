package com.example.product_crud_assignment;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository {
  private final List<Product> products = new ArrayList<>();

  public ProductRepository() {
    products.add(new Product("1", "Product 1", "Headphone", 10.0, 5));
    products.add(new Product("2", "Product 2", "Laptop", 1000.0, 10));
    products.add(new Product("3", "Product 3", "Mobile", 500.0, 15));
  }

  // Implement the method to save a product to the list.
  public Product save(Product product) {
    products.add(product);
   return product;
  }

  //Implement the method to return all products.
  public List<Product> findAll() {
      
      return products;
  }

  //Implement the method to find a product by its ID.
  public Product findById(String id) {
    int index = getProductIndex(id);
    return products.get(index);
  }

  // Implement the method to update a product by its ID.
  public Product update(String id, Product updatedProduct) {
    int index = getProductIndex(id);
    products.set(index, updatedProduct);
    return updatedProduct;
  }

  //Implement the method to delete a product by its ID.
  public void delete(String id) {
    int index = getProductIndex(id);
    products.remove(index);
  }

  // Helper method to find the index of a product by ID
  private int getProductIndex(String id) {
      for (int i = 0; i < products.size(); i++) {
          if (products.get(i).getId().equals(id)) {
              return i;
          }
      }
      return -1;
  }
}
