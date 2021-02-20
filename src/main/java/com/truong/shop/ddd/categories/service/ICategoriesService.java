package com.truong.shop.ddd.categories.service;

import com.truong.shop.ddd.categories.feature.service.dto.featuredto.CategoriesFeatureDTO;

import java.util.List;
import java.util.UUID;

public interface ICategoriesService {
    List<CategoryDTO> getAll();
    CategoryDTO getById(UUID id);
    List<CategoriesFeatureDTO> getAllCategoryFeatureByCategoryId(UUID id);
    void deleteById(UUID id);
    void update(CategoryDTO category) throws Exception;
    void create(CategoryDTO category) throws Exception;
    void createCategoryFeature(CategoriesFeatureDTO dto);
    void deleteCategoryFeatureById(UUID id);
    void updateCategoryFeature(CategoriesFeatureDTO dto);
}
