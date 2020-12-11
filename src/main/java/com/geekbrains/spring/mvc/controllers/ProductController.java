package com.geekbrains.spring.mvc.controllers;

import com.geekbrains.spring.mvc.model.Product;
import com.geekbrains.spring.mvc.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public String allProducts(Model model) {
        model.addAttribute("frontProducts", productService.getAllProducts());
        return "all_products";
    }

    @PostMapping("/add")
    public String addNewBox(@ModelAttribute Product product) {
        productService.addProduct(product);
        return "redirect:/products/all";
    }

    @GetMapping("/remove/{id}")
    public String deleteBoxById(@PathVariable int id) {
        productService.deleteProduct(id);
        return "redirect:/products/all";
    }
}
