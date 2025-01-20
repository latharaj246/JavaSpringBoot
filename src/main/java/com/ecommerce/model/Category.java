package com.ecommerce.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Long CategoryId;
    private String CategoryName;

    public Category(Long categoryId, String categoryName) {
        this.CategoryName = categoryName;
        this.CategoryId = categoryId;
    }

}
