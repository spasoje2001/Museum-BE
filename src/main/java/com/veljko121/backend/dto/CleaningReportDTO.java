package com.veljko121.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CleaningReportDTO {

    private String text;
    private Integer cleaningId;
    private Integer restaurteurId;
}
