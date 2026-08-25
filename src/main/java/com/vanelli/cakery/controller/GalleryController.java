package com.vanelli.cakery.controller;

import com.vanelli.cakery.entity.Gallery;
import com.vanelli.cakery.service.GalleryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin(origins = "*")
public class GalleryController {

    private final GalleryService galleryService;

    public GalleryController(GalleryService galleryService) {
        this.galleryService = galleryService;
    }

    // Galerideki tüm fotoğrafları getirme (Ziyaretçiler ve vitrin için)
    @GetMapping("/all")
    public List<Gallery> getAllGalleryItems() {
        return galleryService.getAllGalleryItems();
    }

    // Admin panelinden yeni pasta fotoğrafı ekleme
    @PostMapping("/add")
    public Gallery addGalleryItem(@RequestBody Gallery gallery) {
        return galleryService.addGalleryItem(gallery);
    }

    // Admin panelinden galeri fotoğrafı silme
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteGalleryItem(@PathVariable Long id) {
        galleryService.deleteGalleryItem(id);
        return ResponseEntity.noContent().build();
    }
}