package com.truong.shop.ddd.product.specialfeature;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IProductSpecialFeatureRepository extends JpaRepository<ProductSpecialFeature,UUID> {
    boolean existsByNameAndProduct_Id(String name, UUID id);
    boolean existsById(UUID id);
    List<ProductSpecialFeature> getAllByProduct_Id(UUID id);
}
