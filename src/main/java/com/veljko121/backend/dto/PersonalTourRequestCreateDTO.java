package com.veljko121.backend.dto;

import com.veljko121.backend.model.PersonalTourRequest;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PersonalTourRequestCreateDTO {

    //@OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = false)
    //private List<Exhibition> exhibitions = new ArrayList<>();  Izlozba jos ne postoji tek kada se bude spojila grana treba otkomentarisati

    private String guestNumber;

    private LocalDateTime occurrenceDateTime;

    private Integer proposerId;

    private Integer organizerId;

}
