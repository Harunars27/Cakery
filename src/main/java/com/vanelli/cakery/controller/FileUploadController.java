package com.vanelli.cakery.controller;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin(origins = "*")
public class FileUploadController {

    private final Cloudinary cloudinary;

    public FileUploadController(
            @Value("${CLOUDINARY_CLOUD_NAME}") String cloudName,
            @Value("${CLOUDINARY_API_KEY}") String apiKey,
            @Value("${CLOUDINARY_API_SECRET}") String apiSecret) {

        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", cloudName,
                "api_key", apiKey,
                "api_secret", apiSecret,
                "secure", true
        ));
    }

    @PostMapping("/multiple")
    public String uploadFiles(@RequestParam("files") MultipartFile[] files) {
        StringBuilder fileUrls = new StringBuilder();

        try {
            for (MultipartFile file : files) {
                if (file.isEmpty()) continue;

                Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                String imageUrl = (String) uploadResult.get("secure_url");

                if (fileUrls.length() > 0) {
                    fileUrls.append(",");
                }
                fileUrls.append(imageUrl);
            }
            return fileUrls.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}