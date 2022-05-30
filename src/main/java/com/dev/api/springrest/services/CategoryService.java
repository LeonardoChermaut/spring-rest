package com.dev.api.springrest.services;

import com.dev.api.springrest.dtos.CategoryDTO;
import com.dev.api.springrest.models.Category;
import com.dev.api.springrest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {
    final CategoryRepository categoryRepository;
    final MapperService mapperService;

    public CategoryService(CategoryRepository categoryRepository, MapperService mapperService) {
        this.categoryRepository = categoryRepository;
        this.mapperService = mapperService;

    }

    public void saveCategory(CategoryDTO categoryDTO) {
        Category category = mapperService.dtoToCategory(categoryDTO);
        categoryRepository.save(category);
    }

    public CategoryDTO findOneCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        Category categoryOnData;
        CategoryDTO categoryDTO = new CategoryDTO();
        if (category.isPresent()) {
            categoryOnData = category.get();
            categoryDTO = mapperService.categoryToDTO(category.get());
        }
        return categoryDTO;
    }

    public void updateCategory(Long id, CategoryDTO categoryDTO) {
        Category category = categoryRepository.findById(id).orElseThrow();
        if (categoryDTO.getName() != null) {
            category.setName(categoryDTO.getName());
        }
        if (categoryDTO.getDescription() != null) {
            category.setDescription(categoryDTO.getDescription());
        }
        categoryRepository.save(category);
    }

    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    public List<CategoryDTO> listAll() {
        return categoryRepository.findAll()
                .stream()
                .map(mapperService::categoryToDTO)
                .collect(Collectors.toList());
    }


}
