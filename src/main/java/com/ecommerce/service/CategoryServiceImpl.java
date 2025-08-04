package com.ecommerce.service;

import com.ecommerce.Repositories.CategoryRepository;
import com.ecommerce.exceptions.ResourceNotFondException;
import com.ecommerce.model.Category;
import com.ecommerce.payload.CategoryDTO;
import com.ecommerce.payload.CategoryResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ModelMapper modelMapper;

    //Listing Category
    @Override
    public CategoryResponse getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty())
            throw new ResourceNotFondException("category" , "categoryId" , (String) null);

            List<CategoryDTO> categoryDTOS = categories.stream()
                    .map(category -> modelMapper.map(category, CategoryDTO.class))
                    .toList();

            CategoryResponse categoryResponse = new CategoryResponse();
            categoryResponse.setContent(categoryDTOS);
            return categoryResponse;

    }

    //Creating category
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category categoryFromDb = categoryRepository.findByCategoryName(category.getCategoryName());
        if (categoryFromDb != null) {
            throw new ResourceNotFondException("Category", "categoryName", category.getCategoryName());
        }
          Category saveCatogory =  categoryRepository.save(category);
        return modelMapper.map(saveCatogory, CategoryDTO.class);
    }

    //Deleting category
    @Override
    public String deleteCategory(Long categoryId) {
 Category category = categoryRepository.findById(categoryId)
         .orElseThrow(() ->  new ResourceNotFondException("Category" , "categoryId" , categoryId ));

        categoryRepository.delete(category);
        return "Category with categoryId " + categoryId + " Deleted";

    }
//updateing category
@Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryId) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFondException("Category" , "categoryId" , categoryId ));
        categoryDTO.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDTO.class);
    }

}
