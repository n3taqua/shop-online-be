package com.truong.shop.ddd.product.specialfeature.service;


import com.truong.shop.ddd.product.Product;
import com.truong.shop.ddd.product.specialfeature.ProductSpecialFeature;
import com.truong.shop.ddd.product.specialfeature.value.service.ProductSpecialFeatureValueMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ProductSpecialFeatureMapper {
    private final ProductSpecialFeatureValueMapper valueMapper;
    @PersistenceContext
    EntityManager manager;
    public ProductSpecialFeatureDTO toDTO(ProductSpecialFeature feature){
        return ProductSpecialFeatureDTO.builder()
                .id(feature.getId())
                .productId(feature.getProduct().getId())
                .name(feature.getName())
                .values(
                        feature.getValues().stream()
                                .map(valueMapper::toDTO)
                                .collect(Collectors.toList())
                )
                .build();
    }

    public ProductSpecialFeature mapped(ProductSpecialFeatureDTO dto){
        return ProductSpecialFeature.builder()
                .name(dto.getName())
                .product(manager.getReference(Product.class,dto.getProductId()))
                .build();
    }
}
