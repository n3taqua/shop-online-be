package com.truong.shop.ddd.categories.feature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface iCategoriesFeatureRepository extends JpaRepository<CategoriesFeature, UUID> {
        List<CategoriesFeature> getCategoriesFeatureByCategory_Id(UUID id);
}
