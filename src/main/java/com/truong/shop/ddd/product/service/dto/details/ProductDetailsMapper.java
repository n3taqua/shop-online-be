package com.truong.shop.ddd.product.service.dto.details;

import com.truong.shop.ddd.categories.Category;
import com.truong.shop.ddd.categories.feature.service.CategoriesFeatureService;
import com.truong.shop.ddd.product.Product;
import com.truong.shop.ddd.product.image.ImageServiceImpl;
import com.truong.shop.ddd.product.specialfeature.service.ProductSpecialFeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@RequiredArgsConstructor
public class ProductDetailsMapper {
    private final ProductSpecialFeatureService featureService;
    private final CategoriesFeatureService categoriesFeatureService;
    private final ImageServiceImpl imageService;
    @PersistenceContext
    private EntityManager manager;
    public Product mapped(ProductDetailsDTO dto){
        return Product.builder()
                .category(manager.getReference(Category.class,dto.getCategoryId()))
                .name(dto.getName())
                .price(dto.getPrice())
                .sale(dto.getSale())
                .description(dto.getDescription())
                .build();
    }
    public ProductDetailsDTO toDto(Product product){
        return
                ProductDetailsDTO.builder()
                        .categoryId(product.getCategory().getId())
                        .categoryName(product.getCategory().getCategoriesName())
                        .images(product.getImages())
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .sale(product.getSale())
                        .description(product.getDescription())
                        .comments(product.getComments())
                        .features(featureService.getAllByProductId(product.getId()))
                        .categoriesFeatures(categoriesFeatureService.getAllFeatureAndValueByProductId(product.getId()))
                        .build();
    }

}
