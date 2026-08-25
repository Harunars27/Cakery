package com.vanelli.cakery.controller;
import com.vanelli.cakery.entity.SiteSetting;
import com.vanelli.cakery.repository.SiteSettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/settings")
@CrossOrigin(origins = "*")
public class SiteSettingController {
    @Autowired private SiteSettingRepository repo;

    @GetMapping("/all") public List<SiteSetting> getAll() { return repo.findAll(); }
    @PostMapping("/save") public SiteSetting save(@RequestBody SiteSetting setting) { return repo.save(setting); }
}