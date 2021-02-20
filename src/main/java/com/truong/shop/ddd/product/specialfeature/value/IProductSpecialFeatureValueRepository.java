package com.truong.shop.ddd.product.specialfeature.value;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IProductSpecialFeatureValueRepository extends JpaRepository<ProductSpecialFeatureValue,UUID> {
        boolean existsByFeatures_IdAndValue(UUID id, String value);
        boolean existsById(UUID id);
}
