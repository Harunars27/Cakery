package com.vanelli.cakery.controller;

import com.vanelli.cakery.service.GalleryService;
import com.vanelli.cakery.entity.Gallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
@CrossOrigin(origins = "*")
public class GalleryController {

    @Autowired
    private GalleryService galleryService;

    // Galerideki tüm pastaları ana sayfaya (Vitrini) getirme (GET İsteği)
    @GetMapping("/all")
    public List<Gallery> getAllGalleryItems() {
        return galleryService.getAllGalleryItems();
    }

    // Admin panelinden yeni pasta fotoğrafı eklendiğinde bunu kaydetme (POST İsteği)
    @PostMapping("/add")
    public Gallery addGalleryItem(@RequestBody Gallery gallery) {
        return galleryService.addGalleryItem(gallery);
    }
}