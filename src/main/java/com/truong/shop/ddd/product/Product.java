package com.truong.shop.ddd.product;

import com.truong.shop.ddd.categories.Category;
import com.truong.shop.ddd.categories.feature.value.CategoriesFeatureValue;
import com.truong.shop.ddd.product.image.Image;
import com.truong.shop.ddd.product.specialfeature.ProductSpecialFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id",columnDefinition ="BINARY(16)")
    private UUID id;
    @Column(name = "name",length = 125)
    private String name;
    @Column(name = "price")
    private int price;
    @Column(name="sale")
    private int sale;
    @Column(name="description" ,columnDefinition = "LONGTEXT NOT NULL")
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId",nullable = false)
    private Category category;
    @OneToMany(mappedBy = "product",orphanRemoval = true)
    private List<ProductSpecialFeature> features;
    @OneToMany(mappedBy = "product",orphanRemoval = true)
    private List<CategoriesFeatureValue> categoriesFeatureValues;
    @OneToMany(mappedBy = "product",orphanRemoval = true)
    private List<Image> images;
}
