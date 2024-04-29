package com.veljko121.backend.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Data
public class RoomReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @ManyToOne
    @NotNull
    private Room room;

    @Column
    private LocalDateTime startDateTime;

    @Column
    private LocalDateTime endDateTime; // Changed from durationMinutes to endDateTime

    @ManyToOne
    @JoinColumn(name = "exhibition_id", nullable = true)
    private Exhibition exhibition;

//    @OneToMany(mappedBy = "roomReservation", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    private List<ItemReservation> itemReservations;

}
