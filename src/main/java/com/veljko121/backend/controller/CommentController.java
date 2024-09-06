package com.veljko121.backend.controller;

import com.veljko121.backend.dto.CommentDTO;
import com.veljko121.backend.dto.CommentResponseDTO;
import com.veljko121.backend.dto.ReviewDTO;
import com.veljko121.backend.dto.ReviewResponseDTO;
import com.veljko121.backend.mapper.CommentMapper;
import com.veljko121.backend.mapper.ReviewMapper;
import com.veljko121.backend.model.Comment;
import com.veljko121.backend.model.Review;
import com.veljko121.backend.service.ICommentService;
import com.veljko121.backend.service.IReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final ICommentService commentService;
    private final CommentMapper commentMapper;
    @GetMapping("/exhibition/{exhibitionId}")
    public ResponseEntity<List<CommentResponseDTO>> getCommentsByExhibitionId(@PathVariable Integer exhibitionId) {
        List<Comment> comments = commentService.findByExhibitionIdOrderByCommentDateDesc(exhibitionId);

        // Use the mapper to convert the list of Review entities to a list of ReviewResponseDTOs
        List<CommentResponseDTO> commentResponseDTOS = comments.stream()
                .map(commentMapper::mapToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(commentResponseDTOS);
    }

    @PostMapping
    public ResponseEntity<CommentResponseDTO> createComment(@RequestBody CommentDTO commentDTO) {
        Comment createdComment = commentService.createComment(commentDTO);
        CommentResponseDTO dto = commentMapper.mapToDTO(createdComment);
        return ResponseEntity.ok(dto);
    }
}
