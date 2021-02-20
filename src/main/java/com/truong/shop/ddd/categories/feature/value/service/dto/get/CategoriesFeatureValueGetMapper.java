package com.truong.shop.ddd.categories.feature.value.service.dto.get;


import com.truong.shop.ddd.categories.feature.value.CategoriesFeatureValue;
import org.springframework.stereotype.Component;

@Component
public class CategoriesFeatureValueGetMapper {
    public CategoryFeatureValueGetDTO toDTO(CategoriesFeatureValue value){
        return CategoryFeatureValueGetDTO.builder()
                .featureId(value.getFeature().getId())
                .featureName(value.getFeature().getFeatureName())
                .id(value.getId())
                .value(value.getValue())
                .build();
    }
}
