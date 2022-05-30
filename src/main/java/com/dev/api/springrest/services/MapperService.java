package com.dev.api.springrest.services;

import com.dev.api.springrest.dtos.CategoryDTO;
import com.dev.api.springrest.models.Category;
import org.springframework.stereotype.Service;


@Service
public class MapperService {

    public CategoryDTO categoryToDTO(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        return categoryDTO;
    }

    public Category dtoToCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setDescription(categoryDTO.getDescription());
        return category;
    }




}
