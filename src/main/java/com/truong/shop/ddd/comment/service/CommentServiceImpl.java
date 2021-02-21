package com.truong.shop.ddd.comment.service;

import com.truong.shop.ddd.comment.Comment;
import com.truong.shop.ddd.comment.ICommentRepository;
import com.truong.shop.ddd.comment.service.dto.create.CommentCreateDto;
import com.truong.shop.ddd.comment.service.dto.create.CommentCreateMapper;
import com.truong.shop.ddd.comment.service.dto.get.CommentGetDto;
import com.truong.shop.ddd.comment.service.dto.get.CommentGetMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {
    private final ICommentRepository repository;
    private final CommentCreateMapper mapper;
    private final CommentGetMapper getMapper;
    @Override
    public void addComment(CommentCreateDto dto) {
        repository.save(mapper.mapped(dto));
    }

    @Override
    public void deleteCommentById(UUID uuid) {
        repository.deleteById(uuid);
    }

    @Override
    public List<CommentGetDto> getAllByProductId(UUID uuid) {
        return repository.findAllByProductId(uuid).stream().map(getMapper::toDto).collect(Collectors.toList());
    }
}
