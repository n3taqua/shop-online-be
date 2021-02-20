package com.truong.shop.ddd.categories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ICategoriesRepository extends JpaRepository<Category,UUID> {
    boolean existsByCategoriesName(String categoriesName);
    boolean existsById(UUID id);

}
