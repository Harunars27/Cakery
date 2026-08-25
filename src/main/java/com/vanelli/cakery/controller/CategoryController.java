package com.vanelli.cakery.controller;
import com.vanelli.cakery.entity.Category;
import com.vanelli.cakery.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin(origins = "*")
public class CategoryController {
    @Autowired private CategoryRepository repo;

    @GetMapping("/all") public List<Category> getAll() { return repo.findAll(); }
    @PostMapping("/add") public Category add(@RequestBody Category category) { return repo.save(category); }
    @DeleteMapping("/delete/{id}") public void delete(@PathVariable Long id) { repo.deleteById(id); }
}