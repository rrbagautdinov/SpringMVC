package com.geekbrains.spring.mvc.repositories;

import com.geekbrains.spring.mvc.model.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Колбаса", 129));
        productList.add(new Product(2, "Сосиски", 159));
        productList.add(new Product(3, "Ветчина", 199));
        productList.add(new Product(4, "Сыр", 259));
        productList.add(new Product(5, "Карбонад", 299));
    }

    public List<Product> getAllProduct() {
        return Collections.unmodifiableList(productList);
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product getById(int productId) {
        if (productList.size() != 0) {
            for (Product product : productList) {
                if (product.getId() == productId) {
                    return product;
                }
            }
        }
        throw new NoSuchElementException(String.format("Продукта с id: " + productId + " не найдено"));
    }

    public void deleteById(int productId) {
        if (productList.size() != 0) {
            productList.removeIf(product -> product.getId() == productId);
        }
    }
}
