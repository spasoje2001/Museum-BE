package com.veljko121.backend.dto.tours;

import java.time.LocalDateTime;

public class PersonalTourResponseDTO {

    private Integer id;

    //@OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = false)
    //private List<Exhibition> exhibitions = new ArrayList<>();  Izlozba jos ne postoji tek kada se bude spojila grana treba otkomentarisati

    private String duration;

    private LocalDateTime occurrenceDateTime;

    private String adultTicketPrice;

    private String minorTicketPrice;

    private Integer guideId;

    private String guestNumber;

}
