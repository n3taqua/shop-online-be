package com.truong.shop.ddd.product.specialfeature.value;


import com.truong.shop.ddd.product.specialfeature.ProductSpecialFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSpecialFeatureValue implements Serializable {
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
    @ManyToOne
    @JoinColumn(name = "featureId")
    private ProductSpecialFeature features;


}
