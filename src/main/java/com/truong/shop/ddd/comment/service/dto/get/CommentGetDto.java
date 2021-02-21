package com.truong.shop.ddd.comment.service.dto.get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentGetDto {
    private UUID id;
    private String userName;
    private String content;
    private UUID productId;
}
