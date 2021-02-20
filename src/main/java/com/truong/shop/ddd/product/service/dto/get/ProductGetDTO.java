package com.truong.shop.ddd.product.service.dto.get;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductGetDTO {
    private UUID id;
    private String name;
    private int price;
    private int sale;
    private UUID categoryId;
    private String categoryName;
}
