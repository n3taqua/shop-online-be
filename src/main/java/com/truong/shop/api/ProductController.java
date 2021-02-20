package com.truong.shop.api;

import com.truong.shop.ddd.categories.feature.value.service.dto.create.CategoryFeatureValueCreateDTO;
import com.truong.shop.ddd.categories.feature.value.service.dto.update.CategoryFeatureValueUpdateDTO;
import com.truong.shop.ddd.product.image.Image;
import com.truong.shop.ddd.product.service.dto.create.ProductCreateDTO;
import com.truong.shop.ddd.product.service.dto.details.ProductDetailsDTO;
import com.truong.shop.ddd.product.service.dto.filter.FeatureValueFilterDTO;
import com.truong.shop.ddd.product.service.dto.get.ProductGetDTO;
import com.truong.shop.ddd.product.service.dto.update.ProductUpdateDTO;
import com.truong.shop.ddd.product.service.IProductService;
import com.truong.shop.ddd.product.specialfeature.service.ProductSpecialFeatureDTO;
import com.truong.shop.utils.exception.NotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products/")
@RequiredArgsConstructor
@CrossOrigin
public class ProductController {
    private final IProductService service;
    @GetMapping("{id}")
    public ProductDetailsDTO getById(@PathVariable("id") UUID id) {

        return service.getById(id);
    }
    @GetMapping
    public List<ProductGetDTO> getAll(){
        return service.getAll();
    }
    @GetMapping("page/")
    public List<ProductGetDTO> getAllByPage(@RequestParam("page") int page,@RequestParam("size") int size) throws NotExistException {
        return service.getAllByPage(page, size);
    }
    @GetMapping("page/max/")
    public int getMaxPageNumber(@RequestParam("size") int size){
        return service.getMaxPageNumber(size);
    }
    @GetMapping("categories/{id}")
    public List<ProductGetDTO> getByCategoryId(@PathVariable("id") UUID id){
        return service.getByCategoryId(id);
    }
    @GetMapping("categories/{id}/page/")
    public List<ProductGetDTO> getPageByCategoryId(@PathVariable("id") UUID id,@RequestParam("page") int page,
                                                   @RequestParam("size") int size) throws NotExistException {
        return service.getPageByCategoryId(id, page, size);
    }
    @GetMapping("categories/{id}/page/max")
    public int getMaxByNumberByCategoryId(@PathVariable("id") UUID id,@RequestParam("size") int size){
        return service.getMaxPageNumberByCategoryId(id, size);
    }

    @GetMapping("searchByName/")
    public List<ProductGetDTO> searchByName(@RequestParam("name") String name, @RequestParam("page") int page,@RequestParam("size") int size)
    {
        return service.searchByName(name, page, size);
    }
    @GetMapping("searchById/")
    public List<ProductGetDTO> searchByName(@RequestParam("id") UUID id, @RequestParam("page") int page,@RequestParam("size") int size)
    {
        return service.searchById(id, page, size);
    }
    @GetMapping("search_and_filter/")
    public List<ProductGetDTO> searchAndFilterProduct(@RequestParam(value = "productId",required = false) UUID productId, @RequestParam(value = "productName",required = false) String productName
                                                      ,@RequestParam(value = "categoryId",required = false)  UUID categoryID,@RequestParam("page") int page,@RequestParam("size") int size,
                                                      @RequestParam(value = "filterArray",required = false)List<FeatureValueFilterDTO> filterDTOList) throws NotExistException {
        return service.searchPageByCategoryFeatureFilter(productId,productName,categoryID,page,size,filterDTOList);
    }
    @DeleteMapping("{id}")
   // @Secured(value = "ADMIN")
    public void deleteById(@PathVariable("id") UUID id) {
        service.deleteById(id);
    }
    @PutMapping
   // @Secured(value = "ADMIN")
    public void update( @RequestBody ProductUpdateDTO dto) {
        service.update(dto);
    }
    @PostMapping
    //@Secured(value = "ADMIN")
    public  UUID create(@RequestBody ProductCreateDTO dto){

        return service.create(dto);
    }

    @GetMapping("{id}/images/")
    public List<Image> getAllImageByProductId(@PathVariable("id") UUID uuid){
        return service.getAllImageByProductId(uuid);
    }
    @PostMapping("/images/")
    public void createImage(String url){
        service.addImage(url);
    }
    @PutMapping("/images/")
    public void updateImage(Image image){
        service.updateImage(image);
    }
    @DeleteMapping("/images/{id}")
    public void deleteImageByID(@PathVariable("id") UUID uuid){
        service.deleteImageById(uuid);
    }

    @PostMapping("/special_features/")
    //@Secured(value = "ADMIN")
    public void addSpecialFeature(@RequestBody List<ProductSpecialFeatureDTO> dtoList ) throws Exception {
        System.out.println(dtoList.toString());
        for(ProductSpecialFeatureDTO dto:dtoList){
            service.createSpecialFeature(dto);
        }

    }
    @PutMapping("/special_features/")
    //@Secured(value = "ADMIN")
    public  void updateSpecialFeature(@RequestBody ProductSpecialFeatureDTO feature) throws Exception {
        service.updateSpecialFeature(feature);
    }
    @DeleteMapping("/special_features/{id}")
    public void deleteSpecialFeature(@PathVariable UUID id){
        service.deleteSpecialFeatureById(id);
    }



    @PostMapping("/features/")
    public void addValueFeature(@RequestBody List<CategoryFeatureValueCreateDTO> dtoList){
        for (CategoryFeatureValueCreateDTO dto : dtoList) {
            service.addValueCategoryFeature(dto);
        }

    }

    @PutMapping("/features/")
    public void updateValueFeature(@RequestBody CategoryFeatureValueUpdateDTO dto){
        service.updateValueCategoryFeature(dto);
    }

}
