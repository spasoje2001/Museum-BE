package com.veljko121.backend.dto;

import lombok.Data;

import java.util.List;

@Data
public class CommentResponseDTO {
    private Integer id;

    private Integer userId;
    private String userPicture;
    private String userFirstName;
    private String userLastName;
    private boolean isUserCurator;
    private boolean isUserOrganizer;

    private Integer exhibitionId;
    private String exhibitionName;
    private List<CommentResponseDTO> responses;

    private String text;
    private String commentDate;
}
