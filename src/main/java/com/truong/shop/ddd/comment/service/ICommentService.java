package com.truong.shop.ddd.comment.service;

import com.truong.shop.ddd.comment.Comment;
import com.truong.shop.ddd.comment.service.dto.create.CommentCreateDto;
import com.truong.shop.ddd.comment.service.dto.get.CommentGetDto;

import java.util.List;
import java.util.UUID;

public interface ICommentService {
    public void addComment(CommentCreateDto dto);
    public void deleteCommentById(UUID uuid);
    List<CommentGetDto> getAllByProductId(UUID uuid);
}
