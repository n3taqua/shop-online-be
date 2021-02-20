package com.truong.shop.ddd.categories.service;

import com.truong.shop.ddd.categories.Category;
import com.truong.shop.ddd.categories.feature.service.dto.featuredto.CategoriesFeatureDTO;
import com.truong.shop.ddd.categories.feature.service.CategoriesFeatureService;
import com.truong.shop.ddd.categories.ICategoriesRepository;
import com.truong.shop.utils.exception.ExistException;
import com.truong.shop.utils.exception.NotExistException;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class CategoriesServiceImpl implements ICategoriesService {
    private final ICategoriesRepository repository;
    private final CategoriesFeatureService featureService;
    private final CategoryMapper mapper;
    @Override
    public List<CategoryDTO> getAll() {
        return repository.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getById(UUID id) {
        Optional<Category> category=repository.findById(id);
        if(category.isPresent()){
            return mapper.toDTO(category.get());
        }
        return new CategoryDTO();

    }


    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void update(CategoryDTO dto) throws NotExistException {
        if (Boolean.FALSE.equals(repository.existsById(dto.getId())))
            throw new NotExistException();
        System.out.println(dto.getCategoriesName());
        System.out.println(dto.getId());
        Category category=repository.findById(dto.getId()).get();
        System.out.println(category);
        category.setCategoriesName(dto.getCategoriesName());
        System.out.println(category);
        repository.save(category);
    }

    @Override
    public void create(CategoryDTO dto) throws ExistException {
        if (Boolean.TRUE.equals(repository.existsByCategoriesName(dto.getCategoriesName())))
            throw  new ExistException();
        repository.save(mapper.mapped(dto));
    }

    @Override
    public List<CategoriesFeatureDTO> getAllCategoryFeatureByCategoryId(UUID id) {
        return featureService.getAllByCategoryId(id);
    }

    @Override
    public void createCategoryFeature(CategoriesFeatureDTO dto) {
        featureService.create(dto);
    }

    @Override
    public void deleteCategoryFeatureById(UUID id) {
        featureService.delete(id);
    }

    @Override
    public void updateCategoryFeature(CategoriesFeatureDTO dto) {
        featureService.update(dto);
    }

}
