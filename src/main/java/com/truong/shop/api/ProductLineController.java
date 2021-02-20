package com.truong.shop.api;


import com.truong.shop.ddd.productline.ProductLine;
import com.truong.shop.ddd.productline.IProductLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productlines/")
@RequiredArgsConstructor

public class ProductLineController {
    private final IProductLineService service;

    @GetMapping
    public List<ProductLine> getAll() {

        return service.getAll();
    }
    @GetMapping("{id}")
    public ProductLine getById(@PathVariable("id") int id) {

        return service.getById(id);
    }
    @Secured(value = "ADMIN")
    @DeleteMapping("{id}")
    public void deleteById(@PathVariable("id") int id) {
        service.deleteById(id);
    }
    @PutMapping
    @Secured(value = "ADMIN")
    public void update(@RequestBody ProductLine productLine) {
        service.update(productLine);
    }
    @PostMapping
    @Secured(value = "ADMIN")
    public void create(@RequestBody ProductLine productLine){
        service.create(productLine);
    }
}
