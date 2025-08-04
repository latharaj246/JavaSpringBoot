package com.ecommerce.service;

import com.ecommerce.Repositories.CategoryRepository;
import com.ecommerce.exceptions.APIException;
import com.ecommerce.exceptions.ResourceNotFoundException;
import com.ecommerce.model.Category;
import com.ecommerce.payload.CategoryDTO;
import com.ecommerce.payload.CategoryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CategoryServiceImpl implements CategoryService {

//    private List<Category> categories = new ArrayList<>();

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    //Listing Category
    public CategoryResponse getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty())
            throw new APIException("No category created till now ");

        List<CategoryDTO> categoryDTOS = categories.stream()
                .map(category -> modelMapper.map(categories, CategoryDTO.class))
                .toList();
        return modelMapper.map(categoryDTOS, CategoryResponse.class);
    }

    //Creating category
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category categoryFromDb = categoryRepository.findByCategoryName(categoryDTO.getCategoryName());
        if (categoryFromDb != null) {
            throw new APIException("category with the name " + categoryDTO.getCategoryName() + "already exists!!!");

        }
        Category saveCategory = categoryRepository.save(category);
        return modelMapper.map(saveCategory, CategoryDTO.class);
    }

    //Deleting category
    public CategoryDTO deleteCategory(Long categoryId) {
        List<Category> categories = categoryRepository.findAll();
        Category category = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));
        if (category == null) {
            return null;
        }
        categoryRepository.delete(category);
        return modelMapper.map(category, CategoryDTO.class);

    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        List<Category> categories = categoryRepository.findAll();
        Optional<Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();
        if (optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(categoryDTO.getCategoryName());
            return modelMapper.map(existingCategory, CategoryDTO.class);
        } else {
            throw new ResourceNotFoundException("category", "categoryId", categoryId);
        }
    }


}
