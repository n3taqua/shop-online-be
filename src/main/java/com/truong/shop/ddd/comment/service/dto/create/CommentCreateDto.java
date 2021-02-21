package com.truong.shop.ddd.comment.service.dto.create;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentCreateDto {
    private String userName;
    private String content;
    private UUID productId;
}
