package com.veljko121.backend.dto;

import lombok.Data;

@Data
public class CommentDTO {
    private Integer userId;
    private Integer exhibitionId;
    private String comment;
    private Integer parentCommentId;
}

