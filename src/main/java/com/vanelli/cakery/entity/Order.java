package com.vanelli.cakery.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerName;
    private String customerPhone;

    // Frontend'den "Henüz netleşmedi" gibi esnek metinler geleceği için String yaptık
    private String deliveryDate;
    private String deliveryTime;

    private String cakeShape;
    private String portionSize;
    private String cakeType;
    private String creamType;

    @Column(columnDefinition = "TEXT")
    private String themeDetails;
    private String referenceImageUrl;

    private String status = "YENİ SİPARİŞ";

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public String getCustomerPhone() { return customerPhone; }
    public void setCustomerPhone(String customerPhone) { this.customerPhone = customerPhone; }
    public String getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(String deliveryDate) { this.deliveryDate = deliveryDate; }
    public String getDeliveryTime() { return deliveryTime; }
    public void setDeliveryTime(String deliveryTime) { this.deliveryTime = deliveryTime; }
    public String getCakeShape() { return cakeShape; }
    public void setCakeShape(String cakeShape) { this.cakeShape = cakeShape; }
    public String getPortionSize() { return portionSize; }
    public void setPortionSize(String portionSize) { this.portionSize = portionSize; }
    public String getCakeType() { return cakeType; }
    public void setCakeType(String cakeType) { this.cakeType = cakeType; }
    public String getCreamType() { return creamType; }
    public void setCreamType(String creamType) { this.creamType = creamType; }
    public String getThemeDetails() { return themeDetails; }
    public void setThemeDetails(String themeDetails) { this.themeDetails = themeDetails; }
    public String getReferenceImageUrl() { return referenceImageUrl; }
    public void setReferenceImageUrl(String referenceImageUrl) { this.referenceImageUrl = referenceImageUrl; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}