package com.truong.shop.ddd.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IProductRepository extends JpaRepository<Product, UUID> {
    List<Product> getAllByCategory_Id(UUID id);
    Page<Product> getAllByCategory_Id(UUID id,Pageable pageable);
    Page<Product> getAllByIdContainingAndCategory_Id( UUID productID, UUID categoryID,Pageable pageable);
    Page<Product> getAllByNameContainingAndCategory_Id(String name,UUID categoryID,  Pageable pageable);
    Page<Product> getAllByIdContaining(UUID uuid,Pageable pageable);
    Page<Product> getAllByNameContaining(String name,Pageable pageable);
}
