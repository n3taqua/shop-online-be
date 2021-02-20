package com.truong.shop.ddd.categories.feature.value.service.dto.create;

import com.truong.shop.ddd.categories.feature.CategoriesFeature;
import com.truong.shop.ddd.categories.feature.value.CategoriesFeatureValue;
import com.truong.shop.ddd.product.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component

public class CategoryFeatureValueCreateMapper {
    @PersistenceContext
    EntityManager manager;
    public CategoriesFeatureValue mapped(CategoryFeatureValueCreateDTO dto){
        return CategoriesFeatureValue.builder()
                .value(dto.getValue())
                .feature(manager.getReference(CategoriesFeature.class,dto.getFeatureId()))
                .product(manager.getReference(Product.class,dto.getProductId()))
                .build();
    }
}
