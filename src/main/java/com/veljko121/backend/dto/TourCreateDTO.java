package com.veljko121.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class TourCreateDTO {

    private String name;

    private String description;

    private List<Integer> roomIds = new ArrayList<>(); // ???

    private String duration;

    private LocalDateTime eventDateTime;

    private String price;           // Cena mora da se prilagodjava razlicitim grupama korisnika

    private Integer guideId;

}
