package com.ecommerce.service;

import com.ecommerce.Repositories.CategoryRepository;
import com.ecommerce.exceptions.APIException;
import com.ecommerce.exceptions.ResourceNotFoundException;
import com.ecommerce.model.Category;
import com.ecommerce.payload.CategoryDTO;
import com.ecommerce.payload.CategoryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return CategoryResponse;
    }

    //Creating category
    public void createCategory(Category category) {
        Category savdCategory = categoryRepository.findByCategoryName(category.getCategoryName());
        if (savdCategory != null) {
            throw new APIException("category with the name " + category.getCategoryName() + "already exists!!!");
        }
        categoryRepository.save(category);
    }

    //Deleting category
    public String deleteCategory(Long categoryId) {
        List<Category> categories = categoryRepository.findAll();
        Category category = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", categoryId));
        if (category == null) {
            return "category not found ";
        }
        categoryRepository.delete(category);
        return "Category with categoryId " + categoryId + " Deleted";

    }

    public Category updateCategory(Category category, Long categoryId) {
        List<Category> categories = categoryRepository.findAll();
        Optional<Category> optionalCategory = categories.stream()
                .filter(c -> c.getCategoryId().equals(categoryId))
                .findFirst();
        if (optionalCategory.isPresent()) {
            Category existingCategory = optionalCategory.get();
            existingCategory.setCategoryName(category.getCategoryName());
            Category saveCategory = categoryRepository.save(existingCategory);
            return saveCategory;
        } else {
            throw new ResourceNotFoundException("category", "categoryId", categoryId);
        }
    }


}
