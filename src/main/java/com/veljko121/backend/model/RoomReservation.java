package com.veljko121.backend.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;  // Veza sa sobom koja se rezerviše

    @NotNull
    @FutureOrPresent
    @Column(nullable = false)
    private LocalDate startDate;  // Datum početka rezervacije (mora biti u budućnosti ili sadašnjosti)

    @NotNull
    @FutureOrPresent
    @Column(nullable = false)
    private LocalDate endDate;  // Datum završetka rezervacije (mora biti u budućnosti ili sadašnjosti)

    @OneToOne(fetch=FetchType.LAZY, mappedBy = "roomReservation", cascade = CascadeType.ALL)
    private ExhibitionProposal exhibitionProposal;

    public RoomReservation(Room room, LocalDate startDate, LocalDate endDate) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
