package com.truong.shop.ddd.product.service.dto.create;

import com.truong.shop.ddd.categories.Category;
import com.truong.shop.ddd.product.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ProductCreateUpdateMapper {
    @PersistenceContext
    EntityManager manager;
    public ProductCreateDTO toDTO(Product product){
        return ProductCreateDTO.builder()
                .id(product.getId())
                .categoryId(product.getCategory().getId())
                .description(product.getDescription())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }
    public Product mapped(ProductCreateDTO dto){
        return Product.builder().
                price(dto.getPrice())
                .name(dto.getName())
                .description(dto.getDescription())
                .category(manager.getReference(Category.class,dto.getCategoryId())).build();
    }
}
