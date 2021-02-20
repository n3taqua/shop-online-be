package com.truong.shop.ddd.categories;

import com.truong.shop.ddd.categories.feature.CategoriesFeature;
import com.truong.shop.ddd.product.Product;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id",columnDefinition ="BINARY(16)")
    private UUID id;
    @Column(name = "categoriesName",length = 125)
    private String categoriesName;

    @OneToMany(mappedBy = "category",orphanRemoval = true)
    @ToString.Exclude
    private List<Product> lstProduct;

    @OneToMany(mappedBy = "category",orphanRemoval = true)
    @ToString.Exclude
    private List<CategoriesFeature> features;
}
