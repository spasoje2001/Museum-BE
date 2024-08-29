package com.veljko121.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class ExhibitionProposal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "organizer_id", nullable = false)
    private Organizer organizer;  // Veza sa organizatorom koji je predložio izložbu

    @NotNull
    @FutureOrPresent
    @Column(nullable = false)
    private LocalDate startDate;  // Datum početka izložbe (mora biti u budućnosti ili sadašnjosti)

    @FutureOrPresent
    @Column(nullable = false)
    private LocalDate  endDate;  // Datum završetka izložbe (mora biti u budućnosti ili sadašnjosti)

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    private Date proposalDate;  // Datum kreiranja predloga izložbe, postavlja se automatski

    @NotNull
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pricelist_id", nullable = false)
    private ExhibitionPriceList exhibitionPriceList;  // Veza sa cenovnikom izložbe


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_reservation_id")
    private RoomReservation roomReservation;  // Veza sa rezervacijom sobe (opciono)

    public ExhibitionProposal(Organizer organizer, LocalDate startDate, LocalDate endDate, ExhibitionPriceList exhibitionPriceList, RoomReservation roomReservation) {
        this.organizer = organizer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.exhibitionPriceList = exhibitionPriceList;
        this.roomReservation = roomReservation;
    }
}
