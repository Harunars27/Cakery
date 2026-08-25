package com.vanelli.cakery.service;

import com.vanelli.cakery.entity.Product;
import com.vanelli.cakery.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(Long id) {
        // Ürün silinirken diskteki resmi de temizleme mekanizması Service katmanına alındı
        Product product = productRepository.findById(id).orElse(null);
        if (product != null && product.getImageUrl() != null && !product.getImageUrl().isEmpty()) {
            try {
                Path filePath = Paths.get("src/main/resources/static/" + product.getImageUrl());
                Files.deleteIfExists(filePath);
            } catch (Exception e) {
                System.err.println("Fiziksel dosya silinirken hata oluştu: " + e.getMessage());
            }
        }
        productRepository.deleteById(id);
    }
}