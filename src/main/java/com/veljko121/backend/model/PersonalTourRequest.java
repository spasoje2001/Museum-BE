package com.veljko121.backend.model;

import com.veljko121.backend.core.enums.PersonalTourRequestStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "personal_tour_request")
public class PersonalTourRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private LocalDateTime occurrenceDateTime;

    @NotEmpty
    @Column(nullable = false)
    private String guestNumber;

    //@OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = false)
    //private List<Exhibition> exhibitions = new ArrayList<>();  Izlozba jos ne postoji tek kada se bude spojila grana treba otkomentarisati

    @ManyToOne
    @JoinColumn(name = "proposer_id")
    private Guest proposer;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, columnDefinition = "varchar(20) default 'ON_HOLD'")
    private PersonalTourRequestStatus status;

}
