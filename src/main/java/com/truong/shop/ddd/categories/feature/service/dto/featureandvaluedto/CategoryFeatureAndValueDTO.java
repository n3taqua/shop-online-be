package com.truong.shop.ddd.categories.feature.service.dto.featureandvaluedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryFeatureAndValueDTO {
    private UUID id;
    private String featureName;
    private List<CategoryFeatureValueDTO> values;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class CategoryFeatureValueDTO{
        private  UUID id;
        private String value;
    }
}
