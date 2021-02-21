package com.truong.shop.ddd.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ICommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findAllByProductId(UUID id);
}
