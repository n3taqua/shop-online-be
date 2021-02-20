package com.truong.shop.ddd.product.specialfeature.value.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSpecialFeatureValueDTO {
    private UUID id;
    private String value;
}
