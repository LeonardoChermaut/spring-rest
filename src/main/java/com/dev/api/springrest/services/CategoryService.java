package com.dev.api.springrest.services;

import com.dev.api.springrest.dtos.CategoryDTO;
import com.dev.api.springrest.models.Category;
import com.dev.api.springrest.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/category")
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public void saveCategory(CategoryDTO categoryDTO) {
		Category category = new Category();
		categoryToDTO(categoryDTO, category);
		categoryRepository.save(category);
	}
	public CategoryDTO categoryToDTO(CategoryDTO categoryDTO, Category category){

		category.setName(categoryDTO.getName());
		category.setDescription(categoryDTO.getDescription());

		return categoryDTO;
	}
	public Category dtoToCategory(CategoryDTO categoryDTO, Category category){

		categoryDTO.setName(category.getName());
		categoryDTO.setDescription(category.getDescription());

		return category;
	}
	public CategoryDTO findOneCategory(Long id){
		Optional<Category> category = categoryRepository.findById(id);
		Category categoryOnData;
		CategoryDTO categoryDTO = new CategoryDTO();
		if (category.isPresent()){
			categoryOnData = category.get();
			categoryDTO = categoryToDTO(categoryDTO, category.get());
		}
		return categoryDTO;
	}
	public void updateCategory(Long id, CategoryDTO categoryDTO) {
		Optional<Category> category = categoryRepository.findById(id);
		Category categoryOnBank = new Category();

		if (category.isPresent()) {
			categoryOnBank = category.get();
			if (categoryDTO.getName() != null) {
				categoryOnBank.setName(categoryDTO.getName());
			}
			if (categoryDTO.getDescription() != null) {
				categoryOnBank.setDescription(categoryDTO.getDescription());
			}
			categoryRepository.save(categoryOnBank);
		}
	}
	public void deleteCategory(long id){
		categoryRepository.deleteById(id);
	}

	public List<Category> listAll()
	{
		return categoryRepository.findAll();
	}

}
