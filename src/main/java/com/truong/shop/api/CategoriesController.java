package com.truong.shop.api;


import com.truong.shop.ddd.categories.feature.service.dto.featuredto.CategoriesFeatureDTO;
import com.truong.shop.ddd.categories.service.CategoryDTO;
import com.truong.shop.ddd.categories.service.ICategoriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories/")
@RequiredArgsConstructor
@CrossOrigin
public class CategoriesController {
    private final ICategoriesService service;

    @GetMapping
    public List<CategoryDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("{id}")
    public CategoryDTO getById(@PathVariable("id") UUID id) {

        return service.getById(id);
    }


    //@Secured(value = "ADMIN")
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
    @PutMapping
    //@Secured(value = "ADMIN")
    public void update(@RequestBody CategoryDTO dto) throws Exception {
        service.update(dto);
    }
    @PostMapping
   // @Secured(value = "ADMIN")
    public  void create(@RequestBody CategoryDTO dto) throws Exception {
        service.create(dto);
    }


    @GetMapping("/{id}/features/")
    public List<CategoriesFeatureDTO> getAllFeatureByCategoryId(@PathVariable("id") UUID id){
        return service.getAllCategoryFeatureByCategoryId(id);
    }
    @PostMapping("/features/")
    //@Secured(value = "ADMIN")
    public void addFeature(@RequestBody CategoriesFeatureDTO dto){
        service.createCategoryFeature(dto);
    }

    @DeleteMapping("/features/{id}")
    //@Secured(value = "ADMIN")
    public void deleteFeature(@PathVariable("id") UUID id){
        service.deleteCategoryFeatureById(id);
    }

    @PutMapping("/features/")
    //@Secured(value = "ADMIN")
    public void updateFeature(@RequestBody CategoriesFeatureDTO dto){
        service.updateCategoryFeature(dto);
    }
}
