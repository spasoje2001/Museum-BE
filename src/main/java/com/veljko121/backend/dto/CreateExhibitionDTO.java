package com.veljko121.backend.dto;

import com.veljko121.backend.core.enums.ExhibitionTheme;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateExhibitionDTO {

    @NotEmpty
    private String name;

    @NotNull
    private ExhibitionTheme theme;

    @NotEmpty
    private String shortDescription;

    @NotEmpty
    private String longDescription;

    @NotEmpty
    private String picture;

    @NotNull
    private List<Integer> itemIds;

    @NotNull
    private Integer proposalId;

    @NotNull
    private Integer curatorId;
}
