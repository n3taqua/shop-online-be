package com.truong.shop.ddd.categories.feature;


import com.truong.shop.ddd.categories.Category;
import com.truong.shop.ddd.categories.feature.value.CategoriesFeatureValue;
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
@Entity(name = "CategoriesFeature")
public class CategoriesFeature implements Serializable {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id",columnDefinition ="BINARY(16)")

    private UUID id;
    @Column(name = "featureName",length = 50)
    private String featureName;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "categoryID",nullable = false)
    private Category category;

    @OneToMany(mappedBy = "feature",orphanRemoval = true)
    private List<CategoriesFeatureValue> values;
}
