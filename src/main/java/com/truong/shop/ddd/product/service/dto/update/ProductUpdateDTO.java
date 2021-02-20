package com.truong.shop.ddd.product.service.dto.update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateDTO {
    private UUID id;
    private String name;
    private int price;
    private int sale;
    private String description;
    private UUID categoryId;
}
