package com.example.product_crud_assignment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductService {
  private final ProductRepository productRepository;

@Autowired
  public ProductService(ProductRepository productRepository)
   {
      this.productRepository = productRepository;
  }

  //Implement the method to create a product.
  public Product createProduct(Product product) {
      return productRepository.save(product);
  }

  //Implement the method to return all products.
  public List<Product> getAllProducts() {
      return productRepository.findAll(); //might need some fixing
  }

  //  Implement the method to return a product by its ID.
  public Product getProductById(String id) {
      return productRepository.findById(id);
  }

  //  Implement the method to update a product by its ID.
  public Product updateProduct(String id, Product updatedProduct) {
      return productRepository.update(id, updatedProduct);
  }

  //  Implement the method to delete a product by its ID.
  public void deleteProduct(String id) {
      productRepository.delete(id);
  }
}
