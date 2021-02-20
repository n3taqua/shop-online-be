package com.truong.shop.ddd.product.service.dto.update;

import com.truong.shop.ddd.categories.Category;
import com.truong.shop.ddd.product.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ProductUpdateMapper {
    @PersistenceContext
    EntityManager manager;
    public ProductUpdateDTO toDTO(Product product){
        return ProductUpdateDTO.builder()
                .id(product.getId())
                .categoryId(product.getCategory().getId())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .sale(product.getSale())
                .build();
    }
    public Product mapped(ProductUpdateDTO dto){
        return Product.builder()
                .category(manager.getReference(Category.class,dto.getCategoryId()))
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .sale(dto.getSale())
                .build();
    }
}
