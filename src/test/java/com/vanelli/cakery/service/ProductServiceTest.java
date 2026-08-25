package com.vanelli.cakery.service;

import com.vanelli.cakery.entity.Product;
import com.vanelli.cakery.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository; // Gerçek DB yerine taklit (Mock) nesne kullanıyoruz

    @InjectMocks
    private ProductService productService; // Test edilecek asıl servisimiz

    @Test
    void testGetAllProducts() {
        // 1. Arrange (Hazırlık)
        Product p1 = new Product();
        p1.setId(1L);
        p1.setName("Frambuazlı Turta");
        p1.setPrice(350.0);

        Product p2 = new Product();
        p2.setId(2L);
        p2.setName("Çikolatalı Bento");
        p2.setPrice(220.0);

        // Kural koyuyoruz: Repository'den findAll çağrılırsa bu sahte listeyi dön
        when(productRepository.findAll()).thenReturn(Arrays.asList(p1, p2));

        // 2. Act (Çalıştırma)
        // NOT: productService içindeki kendi metodunun adını yazmalısın (örn: getAll(), findAll() vb.)
        List<Product> result = productService.getAllProducts();

        // 3. Assert (Doğrulama)
        assertNotNull(result);
        assertEquals(2, result.size(), "Listede tam olarak 2 ürün olmalı");
        assertEquals("Frambuazlı Turta", result.get(0).getName());

        // Repository'nin findAll metodu tam olarak 1 kere çağrılmış mı?
        verify(productRepository, times(1)).findAll();
    }
}