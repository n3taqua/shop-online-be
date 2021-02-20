package com.truong.shop.ddd.product.service;

import com.truong.shop.ddd.categories.feature.value.service.dto.create.CategoryFeatureValueCreateDTO;
import com.truong.shop.ddd.categories.feature.value.service.dto.update.CategoryFeatureValueUpdateDTO;
import com.truong.shop.ddd.product.image.Image;
import com.truong.shop.ddd.product.service.dto.create.ProductCreateDTO;
import com.truong.shop.ddd.product.service.dto.details.ProductDetailsDTO;
import com.truong.shop.ddd.product.service.dto.filter.FeatureValueFilterDTO;
import com.truong.shop.ddd.product.service.dto.get.ProductGetDTO;
import com.truong.shop.ddd.product.service.dto.update.ProductUpdateDTO;
import com.truong.shop.ddd.product.specialfeature.service.ProductSpecialFeatureDTO;
import com.truong.shop.utils.exception.NotExistException;

import java.util.List;
import java.util.UUID;

public interface IProductService {
    ProductDetailsDTO getById(UUID id);
    List<ProductGetDTO> getAll();
    List<ProductGetDTO> getAllByPage(int page, int size) throws NotExistException;
    int getMaxPageNumber(int size);
    List<ProductGetDTO> getByCategoryId(UUID id);
    List<ProductGetDTO> getPageByCategoryId(UUID id, int page,int size) throws NotExistException;
    int getMaxPageNumberByCategoryId(UUID uuid,int size);
    List<ProductGetDTO> searchPageByCategoryFeatureFilter(UUID productID, String productName, UUID categoryID, int page, int size, List<FeatureValueFilterDTO> filterDTOList) throws NotExistException;
    List<ProductGetDTO> searchByName(String name,int page,int size);
    List<ProductGetDTO> searchById(UUID uuid,int page,int size);
    void deleteById(UUID id);
    void update(ProductUpdateDTO dto);
    UUID create(ProductCreateDTO dto);

    List<Image> getAllImageByProductId(UUID productId);
    void addImage(String url);
    void updateImage(Image image);
    void deleteImageById(UUID uuid);

    void createSpecialFeature(ProductSpecialFeatureDTO dto) throws Exception;
    void updateSpecialFeature(ProductSpecialFeatureDTO dto) throws Exception;
    void deleteSpecialFeatureById(UUID id);


    void addValueCategoryFeature(CategoryFeatureValueCreateDTO dto);
    void updateValueCategoryFeature(CategoryFeatureValueUpdateDTO dto);
}
