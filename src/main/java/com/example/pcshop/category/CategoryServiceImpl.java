package com.example.pcshop.category;

import com.example.pcshop.pc_components.exceptions.ProductAlreadyExists;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category save(Category category) {
        Optional<Category> savedCategory = categoryRepository.findByName(category.getName());
        if (savedCategory.isPresent())
            throw new ProductAlreadyExists("Category already exists with given name: " +category.getName());
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Optional<Category> updateCategory(long id, Category updatedCategory) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            existingCategory.setName(updatedCategory.getName());
            return Optional.of(categoryRepository.save(existingCategory));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public void deleteById(long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
