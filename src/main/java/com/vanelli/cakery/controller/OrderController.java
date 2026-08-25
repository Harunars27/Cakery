package com.vanelli.cakery.controller;
import com.vanelli.cakery.entity.Order;
import com.vanelli.cakery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*")
public class OrderController {

    @Autowired
    private OrderService orderService;

    // Web sitesinden (Sepetten) gelen siparişi veritabanına kaydeder
    @PostMapping("/create")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // Admin panelinde en yeni siparişleri en üstte listeler
    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Admin panelinde siparişin durumunu (Hazırlanıyor vb.) güncellemek için
    @PutMapping("/update-status/{id}")
    public Order updateOrderStatus(@PathVariable Long id, @RequestBody String status) {
        return orderService.updateOrderStatus(id, status);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteOrder(@PathVariable Long id) { orderService.deleteOrder(id); }
}