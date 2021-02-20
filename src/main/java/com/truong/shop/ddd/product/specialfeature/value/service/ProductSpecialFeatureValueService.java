package com.truong.shop.ddd.product.specialfeature.value.service;
import com.truong.shop.ddd.product.specialfeature.value.ProductSpecialFeatureValue;
import com.truong.shop.ddd.product.specialfeature.value.IProductSpecialFeatureValueRepository;
import com.truong.shop.utils.exception.ExistException;
import com.truong.shop.utils.exception.NotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductSpecialFeatureValueService {
    private final ProductSpecialFeatureValueMapper mapper;
    private final IProductSpecialFeatureValueRepository repository;

    public void create(List<ProductSpecialFeatureValueDTO> dtos,UUID featureID){
        dtos.forEach(item-> {
            try {
                create(item,featureID);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public void create(ProductSpecialFeatureValueDTO dto, UUID featureId) throws ExistException {
        if(repository.existsByFeatures_IdAndValue(featureId, dto.getValue()))
            throw new ExistException();
        repository.save(mapper.mapped(dto,featureId));
    }
    public void update(List<ProductSpecialFeatureValueDTO> dtos,UUID featureId){
        dtos.forEach(item->
        {
            try {
                update(item,featureId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
    public void update(ProductSpecialFeatureValueDTO dto,UUID featureId) throws NotExistException {
        if (!repository.existsById(dto.getId()))
            throw new NotExistException();
        ProductSpecialFeatureValue value=mapper.mapped(dto,featureId);
        value.setId(dto.getId());
        repository.save(value);
    }
    public void delete(UUID id){
        repository.deleteById(id);
    }
}
