package com.veljko121.backend.dto.tours;

import com.veljko121.backend.core.enums.PersonalTourRequestStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PersonalTourRequestResponseDTO {

    private Integer id;

    private LocalDateTime occurrenceDateTime;

    private String guestNumber;

    //@OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = false)
    //private List<Exhibition> exhibitions = new ArrayList<>();  Izlozba jos ne postoji tek kada se bude spojila grana treba otkomentarisati

    private Integer proposerId;

    private Integer organizerId;

    private PersonalTourRequestStatus status;

}
