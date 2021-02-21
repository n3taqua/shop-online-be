package com.truong.shop.ddd.comment.service.dto.create;

import com.truong.shop.ddd.comment.Comment;
import com.truong.shop.ddd.product.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
public class CommentCreateMapper {
    @PersistenceContext
    private EntityManager manager;
    public CommentCreateDto toDto(Comment comment){
        return CommentCreateDto.builder()
                .userName(comment.getName())
                .content(comment.getComment())
                .productId(comment.getProduct().getId())
                .build();
    }
    public Comment mapped(CommentCreateDto dto){
        return Comment.builder()
                .name(dto.getUserName())
                .comment(dto.getContent())
                .product(manager.getReference(Product.class,dto.getProductId()))
                .build();
    }
}
