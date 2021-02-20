package com.truong.shop.ddd.product.service.dto.details;

import com.truong.shop.ddd.categories.feature.service.dto.featureandvaluedto.CategoryFeatureAndValueDTO;
import com.truong.shop.ddd.product.image.Image;
import com.truong.shop.ddd.product.specialfeature.service.ProductSpecialFeatureDTO;
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
public class ProductDetailsDTO {
    private UUID id;
    private String name;
    private int price;
    private int sale;
    private String description;
    private  UUID categoryId;
    private String categoryName;
    private List<Image> images;
    private List<CategoryFeatureAndValueDTO> categoriesFeatures;
    private List<ProductSpecialFeatureDTO> features;
}
