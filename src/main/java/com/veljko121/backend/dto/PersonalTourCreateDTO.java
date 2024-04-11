package com.veljko121.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PersonalTourCreateDTO {

    //@OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = false)
    //private List<Exhibition> exhibitions = new ArrayList<>();  Izlozba jos ne postoji tek kada se bude spojila grana treba otkomentarisati

    private String duration;

    private LocalDateTime occurrenceDateTime;

    private String adultTicketPrice;

    private String minorTicketPrice;

    private Integer guideId;

    private Integer organizerId;

    private Integer proposerId;

    private String guestNumber;
}
