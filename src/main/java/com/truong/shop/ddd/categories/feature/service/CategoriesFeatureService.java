package com.truong.shop.ddd.categories.feature.service;

import com.truong.shop.ddd.categories.feature.CategoriesFeature;
import com.truong.shop.ddd.categories.feature.iCategoriesFeatureRepository;
import com.truong.shop.ddd.categories.feature.service.dto.featureandvaluedto.CategoryFeatureAndValueDTO;
import com.truong.shop.ddd.categories.feature.service.dto.featuredto.CategoriesFeatureDTO;
import com.truong.shop.ddd.categories.feature.service.dto.featuredto.CategoriesFeatureMapper;
import com.truong.shop.ddd.categories.feature.value.service.CategoriesFeatureValueService;
import com.truong.shop.ddd.categories.feature.value.service.dto.get.CategoryFeatureValueGetDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CategoriesFeatureService {

    private final iCategoriesFeatureRepository repository;
    private final CategoriesFeatureMapper mapper;
    private final CategoriesFeatureValueService valueService;
    public List<CategoriesFeatureDTO> getAllByCategoryId(UUID id){

        return repository.getCategoriesFeatureByCategory_Id(id).stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    public List<CategoryFeatureAndValueDTO> getAllFeatureAndValueByProductId(UUID id){
        List<CategoryFeatureAndValueDTO> lstFeatureAndValue=new ArrayList<>();
        List<CategoryFeatureValueGetDTO> values=valueService.getAllValueByProductId(id);

        for (CategoryFeatureValueGetDTO valueDTO:values){
            lstFeatureAndValue.add(
                    CategoryFeatureAndValueDTO.builder()
                            .id(valueDTO.getFeatureId())
                        .featureName(valueDTO.getFeatureName()).build()
            );
        }

        lstFeatureAndValue=lstFeatureAndValue.stream().distinct().collect(Collectors.toList());

        lstFeatureAndValue.forEach(item->{
            List<CategoryFeatureAndValueDTO.CategoryFeatureValueDTO>  valueDTOList=new ArrayList<>();
            values.forEach(item2->{
                if(item.getFeatureName().equals(item2.getFeatureName())){
                    valueDTOList.add(
                            CategoryFeatureAndValueDTO.CategoryFeatureValueDTO.builder()
                                    .id(item2.getId())
                                    .value(item2.getValue())
                                    .build()
                    );
                }
            });
            item.setValues(valueDTOList);
        });

        return lstFeatureAndValue;
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
    public void create(CategoriesFeatureDTO dto){
        repository.save(mapper.mapped(dto));
    }
    public void update(CategoriesFeatureDTO dto){
        Optional<CategoriesFeature> feature=repository.findById(dto.getId());
        if(feature.isPresent()){
            feature.get().setFeatureName(dto.getFeatureName());
            repository.save(feature.get());
        }
    }
}
