package com.truong.shop.ddd.categories.feature.value;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface iCategoriesFeatureValueRepository extends JpaRepository<CategoriesFeatureValue,UUID> {
    List<CategoriesFeatureValue> getAllByProduct_Id(UUID id);
}
