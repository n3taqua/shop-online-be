package com.truong.shop.ddd.categories.service;

import com.truong.shop.ddd.categories.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    CategoryDTO toDTO(Category category){
        return  CategoryDTO.builder()
                .id(category.getId())
                .categoriesName(category.getCategoriesName())
                .build();
    }
    Category mapped(CategoryDTO dto){
        return Category.builder()
                .categoriesName(dto.getCategoriesName())
                .build();
    }
}
