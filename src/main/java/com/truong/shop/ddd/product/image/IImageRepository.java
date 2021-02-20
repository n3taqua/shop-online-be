package com.truong.shop.ddd.product.image;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface IImageRepository extends JpaRepository<Image, UUID> {
    List<Image> getAllByProductId(UUID id);
}
