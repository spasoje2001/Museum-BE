package com.veljko121.backend.service;

import com.veljko121.backend.core.service.ICRUDService;
import com.veljko121.backend.dto.CommentDTO;
import com.veljko121.backend.model.Comment;

import java.util.List;

public interface ICommentService extends ICRUDService<Comment, Integer> {
    List<Comment> findRepliesByParentId(Integer parentId);

    List<Comment> findByExhibitionIdOrderByCommentDateDesc(Integer exhibitionId);

    Comment createComment(CommentDTO commentDTO);
}
