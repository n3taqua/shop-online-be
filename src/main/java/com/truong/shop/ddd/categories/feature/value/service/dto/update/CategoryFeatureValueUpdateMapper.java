package com.truong.shop.ddd.categories.feature.value.service.dto.update;

import com.truong.shop.ddd.categories.feature.CategoriesFeature;
import com.truong.shop.ddd.categories.feature.value.CategoriesFeatureValue;
import com.truong.shop.ddd.product.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component

public class CategoryFeatureValueUpdateMapper {
    @PersistenceContext
    EntityManager manager;
    public CategoriesFeatureValue mapped(CategoryFeatureValueUpdateDTO dto){
        return CategoriesFeatureValue.builder()
                .id(dto.getId())
                .value(dto.getValue())
                .feature(manager.getReference(CategoriesFeature.class,dto.getFeatureId()))
                .product(manager.getReference(Product.class,dto.getProductId()))
                .build();
    }
}
