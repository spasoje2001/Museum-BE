package com.veljko121.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class ItemReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;  // Veza sa predmetom koji se rezerviše

    @NotNull
    @ManyToOne
    @JoinColumn(name = "exhibition_id", nullable = false)
    private Exhibition exhibition;  // Veza sa izložbom za koju se predmet rezerviše

    @NotNull
    @Column(nullable = false)
    private LocalDate startDate;  // Datum početka rezervacije predmeta

    @NotNull
    @Column(nullable = false)
    private LocalDate endDate;  // Datum završetka rezervacije predmeta

    public ItemReservation(Item item, Exhibition exhibition, LocalDate startDate, LocalDate endDate) {
        this.item = item;
        this.exhibition = exhibition;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
