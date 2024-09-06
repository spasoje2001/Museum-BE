package com.veljko121.backend.service.impl;

import com.veljko121.backend.core.service.impl.CRUDService;
import com.veljko121.backend.dto.CommentDTO;
import com.veljko121.backend.dto.ReviewDTO;
import com.veljko121.backend.model.*;
import com.veljko121.backend.repository.CommentRepository;
import com.veljko121.backend.repository.ItemRepository;
import com.veljko121.backend.repository.RoomRepository;
import com.veljko121.backend.service.ICommentService;
import com.veljko121.backend.service.IExhibitionService;
import com.veljko121.backend.service.IGuestService;
import com.veljko121.backend.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends CRUDService<Comment, Integer> implements ICommentService {

    private final CommentRepository commentRepository;

    @Autowired
    private IUserService userService;

    @Autowired
    private IExhibitionService exhibitionService;


    @Autowired
    public CommentService(CommentRepository repository) {
        super(repository);
        this.commentRepository = repository;
    }

    public List<Comment> findRepliesByParentId(Integer parentId) {
        return commentRepository.findRepliesByParentId(parentId);
    }

    // Metoda za prikupljanje komentara po izložbi, sortirano po datumu
    public List<Comment> findByExhibitionIdOrderByCommentDateDesc(Integer exhibitionId) {
        return commentRepository.findByExhibitionIdOrderByCommentDateDesc(exhibitionId);
    }

    @Override
    public Comment createComment(CommentDTO commentDTO) {
        Exhibition exhibition = exhibitionService.findById(commentDTO.getExhibitionId());

        // Provera korisničkog ID-a, ako nije poslat, korisnik je anoniman (null)
        User user = (commentDTO.getUserId() != null) ? userService.findById(commentDTO.getUserId()) : null;

        // Provera parentCommentId-a, ako nije poslat, komentar nije odgovor na drugi komentar
        Comment parentComment = (commentDTO.getParentCommentId() != null) ?
                this.findById(commentDTO.getParentCommentId()) : null;

        // Kreiranje novog komentara sa opcionalnim korisnikom i roditeljskim komentarom
        Comment comment = new Comment(user, exhibition, commentDTO.getComment(), parentComment);

        return commentRepository.save(comment);
    }

}
