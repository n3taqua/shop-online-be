package com.truong.shop.ddd.categories.feature.value;

import com.truong.shop.ddd.categories.feature.CategoriesFeature;
import com.truong.shop.ddd.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class CategoriesFeatureValue implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id",columnDefinition ="BINARY(16)")

    private UUID id;
    @Column(name = "value",length = 100)
    private String value;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "featureId",nullable = false)
    private CategoriesFeature feature;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;
}
