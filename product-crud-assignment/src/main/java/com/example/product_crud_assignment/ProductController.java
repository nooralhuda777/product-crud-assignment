package com.example.product_crud_assignment;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
  private List<Product> products = new ArrayList<>();

  //adding Products
  public ProductController() {
    products.add(new Product("1", "Product 1", "Headphone", 10.0, 5));
    products.add(new Product("2", "Product 2", "Laptop", 1000.0, 10));
    products.add(new Product("3", "Product 3", "Mobile", 500.0, 15));
  }

  // Helper method to find the index of a product by ID
private int getProductIndex(String id) {
   for (Product product : products) {
       if (product.getId().equals(id)) {
           return products.indexOf(product);
       }
   }
   // Not found
   return -1;
}

  //Implement the method to add a new product
  @PostMapping
  public Product createProduct(@RequestBody Product product) {
   products.add(product);
   
      return product; // Modify this line to return the added product DONE
  }

  //Implement the method to get all products
  @GetMapping
  public List<Product> getAllProducts() {
      // Add your code here to return the list of products DONE
      return products; // Replace null with the actual list DONE
  }

  //Implement the method to get a product by ID
  @GetMapping("/{id}")
  public Product getProductById(@PathVariable String id) {
     
    int index = getProductIndex(id);
    return products.get(index);
       // Replace null with the actual product DONE
  }

  //Implement the method to update a product
  @PutMapping("/{id}")
  public Product updateProduct(@PathVariable String id, @RequestBody Product updatedProduct) {
      int index = getProductIndex(id);
      products.set(index, updatedProduct);
      return updatedProduct; // Replace null with the updated product DONE
  }

  //Implement the method to delete a product
  @DeleteMapping("/{id}")
  public void deleteProduct(@PathVariable String id) {
    int index = getProductIndex(id);
    products.remove(index); //no need for return 
  }
}
