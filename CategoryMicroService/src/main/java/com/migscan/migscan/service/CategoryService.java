package com.migscan.migscan.service;

import com.migscan.migscan.model.Category;

import java.util.Optional;

public interface CategoryService {

    public Optional<Category> getCategoryById(Long categoryId);

    public Iterable<Category> findAllCategories();

}