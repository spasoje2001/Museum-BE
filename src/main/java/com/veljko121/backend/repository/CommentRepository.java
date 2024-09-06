package com.veljko121.backend.repository;

import com.veljko121.backend.model.Comment;
import com.veljko121.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("SELECT c FROM Comment c WHERE c.parentComment.id = :parentId ORDER BY c.commentDate ASC")
    List<Comment> findRepliesByParentId(@Param("parentId") Integer parentId);

    @Query("SELECT c FROM Comment c WHERE c.exhibition.id = :exhibitionId AND c.parentComment IS NULL ORDER BY c.commentDate DESC")
    List<Comment> findByExhibitionIdOrderByCommentDateDesc(@Param("exhibitionId") Integer exhibitionId);

}
