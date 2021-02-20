package com.truong.shop.ddd.product.specialfeature.value.service;

import com.truong.shop.ddd.product.specialfeature.ProductSpecialFeature;
import com.truong.shop.ddd.product.specialfeature.value.ProductSpecialFeatureValue;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.UUID;

@Component
public class ProductSpecialFeatureValueMapper {
    @PersistenceContext
    EntityManager manager;
    public ProductSpecialFeatureValueDTO toDTO(ProductSpecialFeatureValue value){
        return ProductSpecialFeatureValueDTO.builder()
                .id(value.getId())
                .value(value.getValue())
                .build();
    }

    public ProductSpecialFeatureValue mapped(ProductSpecialFeatureValueDTO dto, UUID featureId){
        return ProductSpecialFeatureValue.builder()
                    .features(manager.getReference(ProductSpecialFeature.class,featureId))
                    .value(dto.getValue())
                    .build();
    }
}
