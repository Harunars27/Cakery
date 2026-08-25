package com.vanelli.cakery.entity;
import jakarta.persistence.*;

@Entity
@Table(name = "settings")
public class SiteSetting {
    @Id
    private String id; // "hero_image" gibi anahtar kelimeler
    private String value;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}