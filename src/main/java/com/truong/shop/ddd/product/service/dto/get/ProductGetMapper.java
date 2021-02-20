package com.truong.shop.ddd.product.service.dto.get;

import com.truong.shop.ddd.product.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class ProductGetMapper {
    @PersistenceContext
    EntityManager manager;
     public ProductGetDTO toDTO(Product product){
        return ProductGetDTO.builder()
                .id(product.getId())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getCategoriesName())
                .name(product.getName())
                .price(product.getPrice())
                .sale(product.getSale()).build();
    }
}
