package com.truong.shop.ddd.product.specialfeature;

import com.truong.shop.ddd.product.Product;
import com.truong.shop.ddd.product.specialfeature.value.ProductSpecialFeatureValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductSpecialFeature implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id",columnDefinition ="BINARY(16)")
    private UUID id;
    @Column(name = "name" ,length = 50)
    private String name;
    @OneToMany(mappedBy = "features",orphanRemoval = true)
    private List<ProductSpecialFeatureValue> values;
    @ManyToOne
    @JoinColumn(name = "productsId",nullable = false)
    private Product product;
}
