package com.vanelli.cakery.repository;

import com.vanelli.cakery.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Admin panelinde en yeni siparişlerin her zaman en üstte listelenmesi için:
    List<Order> findAllByOrderByCreatedAtDesc();

}