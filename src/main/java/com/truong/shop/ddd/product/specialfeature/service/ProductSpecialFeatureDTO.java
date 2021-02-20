package com.truong.shop.ddd.product.specialfeature.service;

import com.truong.shop.ddd.product.specialfeature.value.service.ProductSpecialFeatureValueDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductSpecialFeatureDTO {
    private UUID id;
    private String name;
    private UUID productId;
    private List<ProductSpecialFeatureValueDTO> values;
}
