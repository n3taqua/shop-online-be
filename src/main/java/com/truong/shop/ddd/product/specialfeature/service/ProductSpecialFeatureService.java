package com.truong.shop.ddd.product.specialfeature.service;


import com.truong.shop.ddd.product.specialfeature.ProductSpecialFeature;
import com.truong.shop.ddd.product.specialfeature.IProductSpecialFeatureRepository;
import com.truong.shop.ddd.product.specialfeature.value.service.ProductSpecialFeatureValueService;
import com.truong.shop.utils.exception.ExistException;
import com.truong.shop.utils.exception.NotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductSpecialFeatureService {
    private final IProductSpecialFeatureRepository repository;
    private final ProductSpecialFeatureValueService featureValueService;
    private final ProductSpecialFeatureMapper mapper;

    public List<ProductSpecialFeatureDTO> getAllByProductId(UUID id){
        return repository.getAllByProduct_Id(id).stream()
                            .map(mapper::toDTO).collect(Collectors.toList());
    }
    public void  create(ProductSpecialFeatureDTO feature) throws ExistException {
        if(repository.existsByNameAndProduct_Id(feature.getName(), feature.getProductId()))
            throw new ExistException();

        ProductSpecialFeature specialFeatureReturn=repository.save(mapper.mapped(feature));
        featureValueService.create(feature.getValues(),specialFeatureReturn.getId());

    }
    public void update(ProductSpecialFeatureDTO feature) throws NotExistException {
        if(!repository.existsById(feature.getId()))
            throw new NotExistException();
        ProductSpecialFeature specialFeature=mapper.mapped(feature);
        specialFeature.setId(feature.getId());
        ProductSpecialFeature specialFeatureReturn=repository.save(specialFeature);
        featureValueService.update(feature.getValues(),specialFeatureReturn.getId());
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
}
