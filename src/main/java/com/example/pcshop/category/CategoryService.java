package com.example.pcshop.category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category save(Category category);

    List<Category> findAll();

    Optional<Category> findById(long id);

    Optional<Category> updateCategory(long id, Category updatedCategory);

    void deleteById(long categoryId);
}
