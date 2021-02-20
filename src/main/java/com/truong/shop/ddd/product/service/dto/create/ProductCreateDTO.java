package com.truong.shop.ddd.product.service.dto.create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateDTO {
    private UUID id;
    private String name;
    private int price;
    private String description;
    private UUID categoryId;
}
