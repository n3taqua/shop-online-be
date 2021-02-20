package com.truong.shop.ddd.categories.feature.value.service.dto.get;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryFeatureValueGetDTO {
    private UUID id;
    private UUID featureId;
    private String value;
    private String featureName;
}
