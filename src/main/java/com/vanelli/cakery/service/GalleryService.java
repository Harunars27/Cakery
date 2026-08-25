package com.vanelli.cakery.service;

import com.vanelli.cakery.entity.Gallery;
import com.vanelli.cakery.repository.GalleryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    // Galerideki tüm pastaları ana sayfaya (Vitrini) getirme (GET İsteği)
    public List<Gallery> getAllGalleryItems() {
        return galleryRepository.findAll();
    }

    // Admin panelinden yeni pasta fotoğrafı eklendiğinde bunu kaydetme (POST İsteği)
    public Gallery addGalleryItem(Gallery gallery) {
        return galleryRepository.save(gallery);
    }

    public void deleteGalleryItem(Long id) {
    }
}