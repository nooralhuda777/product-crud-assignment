package com.example.product_crud_assignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
 private final ProductRepository productRepository;

@Autowired
  public ProductServiceImpl(ProductRepository productRepository)
   {
      this.productRepository = productRepository;
  }

  @Override
  public Product createProduct(Product product) {
      return productRepository.save(product);
  }

 @Override
  public List<Product> getAllProducts() {
      return productRepository.findAll(); //might need some fixing
  }

 @Override
  public Product getProductById(Long id) {
      return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }
  

   @Override
  public Product updateProduct(Long id, Product product) {
     Product existingProduct = getProductById(id);
     existingProduct.setName(product.getName());
     existingProduct.setPrice(product.getPrice());
     existingProduct.setQuantity(product.getQuantity());
     return productRepository.save(existingProduct);
  }

 @Override
  public void deleteProduct(Long id) {
      productRepository.deleteById(id);
  }
}
