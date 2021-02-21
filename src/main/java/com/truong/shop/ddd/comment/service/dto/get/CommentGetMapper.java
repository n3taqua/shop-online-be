package com.truong.shop.ddd.comment.service.dto.get;

import com.truong.shop.ddd.comment.Comment;
import com.truong.shop.ddd.comment.service.dto.create.CommentCreateDto;
import com.truong.shop.ddd.product.Product;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Component
public class CommentGetMapper {
    @PersistenceContext
    private EntityManager manager;
    public CommentGetDto toDto(Comment comment){
        return CommentGetDto.builder()
                .id(comment.getId())
                .userName(comment.getName())
                .content(comment.getComment())
                .productId(comment.getProduct().getId())
                .build();
    }
    public Comment mapped(CommentGetDto dto){
        return Comment.builder()
                .name(dto.getUserName())
                .comment(dto.getContent())
                .product(manager.getReference(Product.class,dto.getProductId()))
                .build();
    }
}
