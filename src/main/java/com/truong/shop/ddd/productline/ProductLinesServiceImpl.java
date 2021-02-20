package com.truong.shop.ddd.productline;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ProductLinesServiceImpl implements IProductLineService {
    private final IProductLineRepository repository;
    @Override
    public List<ProductLine> getAll() {
        return repository.findAll();
    }

    @Override
    public ProductLine getById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        repository.findById(id);
    }

    @Override
    public void update(ProductLine productLine) {
        repository.save(productLine);
    }

    @Override
    public void create(ProductLine productLine) {
        repository.save(productLine);
    }
}
