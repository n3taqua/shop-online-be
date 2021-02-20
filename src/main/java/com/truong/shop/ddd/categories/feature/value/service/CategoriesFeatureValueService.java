package com.truong.shop.ddd.categories.feature.value.service;

import com.truong.shop.ddd.categories.feature.value.iCategoriesFeatureValueRepository;
import com.truong.shop.ddd.categories.feature.value.service.dto.create.CategoryFeatureValueCreateDTO;
import com.truong.shop.ddd.categories.feature.value.service.dto.create.CategoryFeatureValueCreateMapper;
import com.truong.shop.ddd.categories.feature.value.service.dto.get.CategoriesFeatureValueGetMapper;
import com.truong.shop.ddd.categories.feature.value.service.dto.get.CategoryFeatureValueGetDTO;
import com.truong.shop.ddd.categories.feature.value.service.dto.update.CategoryFeatureValueUpdateDTO;
import com.truong.shop.ddd.categories.feature.value.service.dto.update.CategoryFeatureValueUpdateMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriesFeatureValueService {
    private final iCategoriesFeatureValueRepository repository;
    private final CategoriesFeatureValueGetMapper getMapper;
    private final CategoryFeatureValueCreateMapper createMapper;
    private final CategoryFeatureValueUpdateMapper updateMapper;
    public List<CategoryFeatureValueGetDTO> getAllValueByProductId(UUID id){
        return repository.getAllByProduct_Id(id).stream()
                .map(getMapper::toDTO).collect(Collectors.toList());
    }
    void delete(UUID id){
        repository.deleteById(id);
    }
    public void create(CategoryFeatureValueCreateDTO dto){
        repository.save(createMapper.mapped(dto));
    }
    public void update(CategoryFeatureValueUpdateDTO dto){
        repository.save(updateMapper.mapped(dto));
    }
}
