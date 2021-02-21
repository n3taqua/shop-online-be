package com.truong.shop.ddd.comment;

import com.truong.shop.ddd.product.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name="UUID",
            strategy =  "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;
    @Column(name = "name",length = 45)
    private String name;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "productId",nullable = false)
    private Product product;
}
