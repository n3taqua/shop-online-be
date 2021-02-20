package com.truong.shop.ddd.categories.feature.service.dto.featuredto;

import com.truong.shop.ddd.categories.Category;
import com.truong.shop.ddd.categories.feature.CategoriesFeature;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component

public class CategoriesFeatureMapper {
    @PersistenceContext
    EntityManager manager;
    public CategoriesFeatureDTO toDTO(CategoriesFeature feature){
        return CategoriesFeatureDTO.builder()
                .id(feature.getId())
                .categoryId(feature.getCategory().getId())
                .featureName(feature.getFeatureName())
                .build();
    }
    public CategoriesFeature mapped(CategoriesFeatureDTO dto){
        return CategoriesFeature.builder()
                .featureName(dto.getFeatureName())
                .category(manager.getReference(Category.class,dto.getCategoryId()))
                .build();
    }
}
