package com.geekbrains.spring.mvc.services;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getAllProduct();
    }

    public void addProduct(Product product) {
        try {
            productRepository.addProduct(product);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(int productId) {
        productRepository.deleteById(productId);
    }
}
