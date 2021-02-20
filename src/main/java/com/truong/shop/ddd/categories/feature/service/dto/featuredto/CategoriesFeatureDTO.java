package com.truong.shop.ddd.categories.feature.service.dto.featuredto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoriesFeatureDTO {
    private UUID id;
    private String featureName;
    private UUID categoryId;
}
