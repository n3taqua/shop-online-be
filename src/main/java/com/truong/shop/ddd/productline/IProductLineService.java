package com.truong.shop.ddd.productline;

import java.util.List;

public interface IProductLineService {
    List<ProductLine> getAll();
    ProductLine getById(int id);
    void deleteById(int id);
    void update(ProductLine productLine);
    void create(ProductLine productLine);
}
