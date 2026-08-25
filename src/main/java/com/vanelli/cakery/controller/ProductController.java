package com.vanelli.cakery.controller;

import com.vanelli.cakery.entity.Product;
import com.vanelli.cakery.service.ProductService;
import jakarta.validation.Valid; // Eklendi
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Product addProduct(@Valid @RequestBody Product product) { // @Valid eklendi
        return productService.addProduct(product);
    }

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/update/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) { // @Valid eklendi
        product.setId(id);
        return productService.addProduct(product);
    }
}