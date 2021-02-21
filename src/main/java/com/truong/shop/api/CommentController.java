package com.truong.shop.api;

import com.truong.shop.ddd.comment.Comment;
import com.truong.shop.ddd.comment.service.ICommentService;
import com.truong.shop.ddd.comment.service.dto.create.CommentCreateDto;
import com.truong.shop.ddd.comment.service.dto.get.CommentGetDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/comment/")
@RequiredArgsConstructor
public class CommentController {
    private final ICommentService service;
    @GetMapping("{productId}")
    public List<CommentGetDto> getByProductId(@PathVariable("productId") UUID uuid){
     return service.getAllByProductId(uuid);
    }
    @PostMapping
    public void addComment(@RequestBody CommentCreateDto comment){
        service.addComment(comment);
    }
    @DeleteMapping("{id}")
    public  void deleteCommentById(@PathVariable("id") UUID uuid){
        service.deleteCommentById(uuid);
    }
}
