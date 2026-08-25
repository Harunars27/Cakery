package com.vanelli.cakery.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ürün adı boş olamaz!")
    private String name;

    private String category;

    @Min(value = 0, message = "Fiyat 0'dan küçük olamaz!")
    private Double price;

    @Column(columnDefinition = "TEXT")
    private String imageUrl;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String section;
    private String sizeOptions;
    private String flavorOptions;

    // YENİ EKLENENLER (Versiyon 2.0)
    private Boolean isActive = true; // Aktif-Pasif kontrolü (Soft-delete)
    private String allergens; // Alerjen Uyarıları

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getSection() { return section; }
    public void setSection(String section) { this.section = section; }
    public String getSizeOptions() { return sizeOptions; }
    public void setSizeOptions(String sizeOptions) { this.sizeOptions = sizeOptions; }
    public String getFlavorOptions() { return flavorOptions; }
    public void setFlavorOptions(String flavorOptions) { this.flavorOptions = flavorOptions; }
    public Boolean getIsActive() { return isActive; }
    public void setIsActive(Boolean isActive) { this.isActive = isActive; }
    public String getAllergens() { return allergens; }
    public void setAllergens(String allergens) { this.allergens = allergens; }
}