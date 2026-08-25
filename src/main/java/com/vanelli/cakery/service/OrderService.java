package com.vanelli.cakery.service;

import com.vanelli.cakery.entity.Order;
import com.vanelli.cakery.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Repository'e eklediğimiz o özel metodu (en yeniler en üstte) burada kullanıyoruz
    public List<Order> getAllOrders() {
        return orderRepository.findAllByOrderByCreatedAtDesc();
    }

    // Siparişin durumunu (Yeni, Hazırlanıyor vb.) günceller
    public Order updateOrderStatus(Long id, String status) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            order.setStatus(status.replace("\"", "")); // JSON'dan gelen tırnakları temizler
            return orderRepository.save(order);
        }
        return null;
    }
    public void deleteOrder(Long id) { orderRepository.deleteById(id); }
}