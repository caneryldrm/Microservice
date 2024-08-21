package com.migscan.migscan.controller;

import com.migscan.migscan.model.Category;
import com.migscan.migscan.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        super();
        this.categoryService = categoryService;
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Optional<Category>> restGetCategoryById(@PathVariable("categoryId") Long categoryId) {
        return new ResponseEntity<Optional<Category>>(categoryService.getCategoryById(categoryId), HttpStatus.FOUND);
    }

    @GetMapping("/categories")
    public ResponseEntity<Iterable<Category>> restGetAllCategory() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.findAllCategories());
    }
}