package com.truong.shop.ddd.categories.feature.value.service.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryFeatureValueCreateDTO {
    private String value;
    private UUID featureId;
    private UUID productId;
}
