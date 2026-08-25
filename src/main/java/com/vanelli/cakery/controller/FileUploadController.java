package com.vanelli.cakery.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@RestController
@RequestMapping("/api/upload")
@CrossOrigin(origins = "*")
public class FileUploadController {

    // Fotoğrafların fiziksel olarak kaydedileceği klasör (Projenin static klasörü)
    private static final String UPLOAD_DIR = "src/main/resources/static/";

    @PostMapping("/multiple")
    public String uploadFiles(@RequestParam("files") MultipartFile[] files) {
        StringBuilder fileNames = new StringBuilder();

        try {
            // Eğer klasör yoksa oluştur
            File dir = new File(UPLOAD_DIR);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            for (MultipartFile file : files) {
                if (file.isEmpty()) continue;

                // Aynı isimde iki dosya yüklenirse çakışmasın diye benzersiz (UUID) bir kod ekliyoruz
                String uniqueFileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
                Path path = Paths.get(UPLOAD_DIR + uniqueFileName);

                // Dosyayı sunucuya kaydet
                Files.write(path, file.getBytes());

                // Veritabanına yazılacak isimleri virgülle birleştir (Çoklu fotoğraf desteği için)
                if (fileNames.length() > 0) {
                    fileNames.append(",");
                }
                fileNames.append(uniqueFileName);
            }
            return fileNames.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return "error";
        }
    }
}