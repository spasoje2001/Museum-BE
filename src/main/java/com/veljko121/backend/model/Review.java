package com.veljko121.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "guest_id", nullable = false)
    private Guest guest;  // Veza sa posetiocem koji je napisao recenziju

    @ManyToOne
    @JoinColumn(name = "exhibition_id", nullable = false)
    private Exhibition exhibition;  // Veza sa izložbom za koju je recenzija napisana

    @Min(1)
    @Max(5)
    @Column(nullable = false)
    private int rating;  // Ocena izložbe, npr. od 1 do 5

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;  // Tekstualni komentar posetioca

    @CreationTimestamp
    @Column(name = "review_date",nullable = false, updatable = false)
    private LocalDate reviewDate;  // Datum kada je recenzija napisana

    // Konstruktor sa svim parametrima
    public Review(Guest guest, Exhibition exhibition, int rating, String comment) {
        this.guest = guest;
        this.exhibition = exhibition;
        this.rating = rating;
        this.comment = comment;
    }
}
