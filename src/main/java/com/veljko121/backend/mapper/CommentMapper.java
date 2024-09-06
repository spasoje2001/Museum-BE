package com.veljko121.backend.mapper;

import com.veljko121.backend.core.enums.Role;
import com.veljko121.backend.dto.CommentResponseDTO;
import com.veljko121.backend.dto.ReviewResponseDTO;
import com.veljko121.backend.model.Comment;
import com.veljko121.backend.model.Review;
import com.veljko121.backend.service.ICommentService;
import com.veljko121.backend.service.ICuratorService;
import com.veljko121.backend.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CommentMapper {

    @Autowired
    private ICommentService commentService;
    public CommentResponseDTO mapToDTO(Comment comment){
        CommentResponseDTO dto = new CommentResponseDTO();
        dto.setId(comment.getId());
        dto.setText(comment.getText());
        dto.setCommentDate(DateUtil.dateToString(comment.getCommentDate()));

        dto.setExhibitionId(comment.getExhibition().getId());
        dto.setExhibitionName(comment.getExhibition().getName());

        if (comment.getUser() != null) {
            dto.setUserId(comment.getUser().getId());
            dto.setUserPicture(comment.getUser().getPicture());
            dto.setUserFirstName(comment.getUser().getFirstName());
            dto.setUserLastName(comment.getUser().getLastName());

            // Postavljanje boolean vrednosti
            dto.setUserCurator(comment.getUser().getRole().equals(Role.CURATOR));
            dto.setUserOrganizer(comment.getUser().getRole().equals(Role.ORGANIZER));
        } else {
            dto.setUserId(null);
            dto.setUserPicture("assets/default-profile-picture.png");
            dto.setUserFirstName("Anonymous");
            dto.setUserLastName("");
            dto.setUserCurator(false);
            dto.setUserOrganizer(false);
        }

        // Pretpostavljam da ti treba još implementacija za postavljanje odgovora (ako postoji)
        if (comment.getParentComment() == null) {
            // Mapiraj odgovore samo ako ovaj komentar nije odgovor na drugi komentar
            dto.setResponses(
                    commentService.findRepliesByParentId(comment.getId()).stream()
                            .map(this::mapToDTO)
                            .collect(Collectors.toList())
            );
        }

        return dto;
    }
}
