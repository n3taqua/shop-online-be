package com.truong.shop.ddd.product.service;

import com.truong.shop.ddd.categories.feature.service.CategoriesFeatureService;
import com.truong.shop.ddd.categories.feature.value.service.CategoriesFeatureValueService;
import com.truong.shop.ddd.categories.feature.value.service.dto.create.CategoryFeatureValueCreateDTO;
import com.truong.shop.ddd.categories.feature.value.service.dto.update.CategoryFeatureValueUpdateDTO;
import com.truong.shop.ddd.product.Product;
import com.truong.shop.ddd.product.IProductRepository;
import com.truong.shop.ddd.product.image.Image;
import com.truong.shop.ddd.product.image.ImageServiceImpl;
import com.truong.shop.ddd.product.service.dto.create.ProductCreateDTO;
import com.truong.shop.ddd.product.service.dto.create.ProductCreateUpdateMapper;
import com.truong.shop.ddd.product.service.dto.details.ProductDetailsDTO;
import com.truong.shop.ddd.product.service.dto.details.ProductDetailsMapper;
import com.truong.shop.ddd.product.service.dto.filter.FeatureValueFilterDTO;
import com.truong.shop.ddd.product.service.dto.get.ProductGetDTO;
import com.truong.shop.ddd.product.service.dto.get.ProductGetMapper;
import com.truong.shop.ddd.product.service.dto.update.ProductUpdateDTO;
import com.truong.shop.ddd.product.service.dto.update.ProductUpdateMapper;
import com.truong.shop.ddd.product.specialfeature.service.ProductSpecialFeatureDTO;
import com.truong.shop.ddd.product.specialfeature.service.ProductSpecialFeatureService;
import com.truong.shop.utils.exception.NotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;
    private final ProductUpdateMapper updateMapper;
    private final ProductGetMapper getMapper;
    private final ProductDetailsMapper detailsMapper;
    private final ProductCreateUpdateMapper createUpdateMapper;
    private final ProductSpecialFeatureService featureService;
    private final CategoriesFeatureService categoriesFeatureService;
    private final CategoriesFeatureValueService categoriesFeatureValueService;
    private final ImageServiceImpl imageService;
    @Override
    public ProductDetailsDTO getById(UUID id) {
        Optional<Product> product=repository.findById(id);
        if (product.isPresent()){
            return detailsMapper.toDto(product.get());
        }
        return new ProductDetailsDTO();

    }

    @Override
    public List<ProductGetDTO> getAll() {
        return repository.findAll().stream().map(getMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductGetDTO> getAllByPage(int page, int size) throws NotExistException {
        Page<Product> productPage= repository.findAll(PageRequest.of(page,size));
        if(page>productPage.getTotalPages()){
            throw new NotExistException();
        }
        return productPage.getContent().stream().map(getMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public int getMaxPageNumber(int size) {
        return repository.findAll(PageRequest.of(0,size)).getTotalPages();
    }
    @Override
    public List<ProductGetDTO> getByCategoryId(UUID id) {
        return repository.getAllByCategory_Id(id).stream().map(getMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductGetDTO> getPageByCategoryId(UUID id, int page, int size) throws NotExistException {
        Page<Product> productPage= repository.getAllByCategory_Id(id,PageRequest.of(page,size));
        if(page>productPage.getTotalPages()){
            throw new NotExistException();
        }
        return productPage.getContent().stream().map(getMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public int getMaxPageNumberByCategoryId(UUID uuid, int size) {
        return  repository.getAllByCategory_Id(uuid,PageRequest.of(0,size)).getTotalPages();
    }

    @Override
    public List<ProductGetDTO> searchPageByCategoryFeatureFilter(UUID productID, String productName, UUID categoryID,
                                                                 int page, int size, List<FeatureValueFilterDTO> filterDTOList) throws NotExistException {
        List<Product> emptyList=new ArrayList<>();
        Page<Product> productPage=new PageImpl<Product>(emptyList);
        if(categoryID!=null){
            if((productID!=null) || (productName!=null)){
                if(productName!=null){
                    productPage=repository.getAllByNameContainingAndCategory_Id(productName,categoryID,PageRequest.of(page,size));
                }
                else {
                    productPage=repository.getAllByIdContainingAndCategory_Id(productID,categoryID,PageRequest.of(page,size));
                }
                System.out.println(productPage.toString());
            }else{
                productPage=repository.getAllByCategory_Id(categoryID,PageRequest.of(page,size));
            }
        }
        else {
            if((productID!=null) || (productName!=null)){
                if(productName!=null){
                    productPage=repository.getAllByNameContaining(productName,PageRequest.of(page,size));
                }
                else {
                    productPage=repository.getAllByIdContaining(productID,PageRequest.of(page,size));
                }
                System.out.println(productPage.toString());
            }
            else {
                productPage= repository.findAll(PageRequest.of(page,size));
            }
        }
        if(page>productPage.getTotalPages()){
            throw new NotExistException();
        }
        if(filterDTOList!=null){
            List<ProductGetDTO> productGetDTOList=new ArrayList<>();
            productPage.forEach(product -> {
                product.getCategory().getFeatures().forEach(feature -> {
                    filterDTOList.forEach(filter->{
                        if(filter.getFeatureId().equals(feature.getId())){
                            feature.getValues().forEach(value -> {
                                if(value.getProduct().getId()==product.getId()){
                                    filter.getValue().forEach(valueFilter->{
                                        if(value.getValue().equals(valueFilter)){
                                            productGetDTOList.add(
                                                    getMapper.toDTO(product)
                                            );
                                        }
                                    });
                                }
                            });
                        }
                    });
                });
            });
            return productGetDTOList;
        }
       return productPage.stream().map(getMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductGetDTO> searchByName(String name,int page,int size) {
        return repository.getAllByNameContaining(name,PageRequest.of(page, size)).stream().map(getMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductGetDTO> searchById(UUID uuid,int page,int size) {
        return repository.getAllByIdContaining(uuid,PageRequest.of(page, size)).stream().map(getMapper::toDTO).collect(Collectors.toList());

    }


    @Override
    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public void update(ProductUpdateDTO dto) {
        Product product=updateMapper.mapped(dto);
        repository.save(product);
    }

    @Override
    public UUID create(ProductCreateDTO dto) {
        Product product=createUpdateMapper.mapped(dto);
        return repository.save(product).getId();

    }

    @Override
    public List<Image> getAllImageByProductId(UUID productId) {
        return imageService.getAllImageByProductId(productId);
    }

    @Override
    public void addImage(String url) {
        imageService.create(url);
    }

    @Override
    public void updateImage(Image image) {
        imageService.update(image);
    }

    @Override
    public void deleteImageById(UUID uuid) {
        imageService.deleteById(uuid);
    }


    @Override
    public void createSpecialFeature(ProductSpecialFeatureDTO dto) throws Exception {
        featureService.create(dto);
    }

    @Override
    public void updateSpecialFeature(ProductSpecialFeatureDTO dto) throws Exception {
        featureService.update(dto);
    }

    @Override
    public void deleteSpecialFeatureById(UUID id) {
        featureService.delete(id);
    }



    @Override
    public void addValueCategoryFeature(CategoryFeatureValueCreateDTO dto) {
        categoriesFeatureValueService.create(dto);
    }

    @Override
    public void updateValueCategoryFeature(CategoryFeatureValueUpdateDTO dto) {
        categoriesFeatureValueService.update(dto);
    }
}
