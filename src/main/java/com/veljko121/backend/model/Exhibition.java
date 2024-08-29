package com.veljko121.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.veljko121.backend.core.enums.ExhibitionStatus;
import com.veljko121.backend.core.enums.ExhibitionTheme;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.ToString;
import org.hibernate.Remove;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Exhibition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "exhibition_proposal_id", nullable = false)
    private ExhibitionProposal exhibitionProposal;

    @Column(nullable = false)
    private String name;

    private String picture;

    @Column
    private String shortDescription;

    @Column(name = "long_description", columnDefinition = "TEXT")
    private String longDescription;

    @Enumerated(EnumType.STRING)
    private ExhibitionTheme theme;

    @Enumerated(EnumType.STRING)
    private ExhibitionStatus status;

    @ManyToOne
    @JoinColumn(name = "curator_id")
    private Curator curator;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "exhibition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemReservation> itemReservations = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "exhibition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "exhibition", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    public boolean isOngoing() {
        LocalDate currentDate = LocalDate.now();
        LocalDate startDate = exhibitionProposal.getStartDate();
        LocalDate endDate = exhibitionProposal.getEndDate();

        // The exhibition is ongoing if it has started and either has no end date (permanent) or hasn't ended yet (temporary).
        return !currentDate.isBefore(startDate) && (endDate == null || currentDate.isBefore(endDate));
    }

    public BigDecimal getRevenue() {
        return tickets.stream()
                .map(Ticket::getTotalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean isFree() {
        return tickets.isEmpty() || tickets.stream()
                .allMatch(ticket -> BigDecimal.ZERO.compareTo(ticket.getTotalPrice()) == 0);
    }

    public double getAverageRating() {
        double average = reviews.stream()
                .mapToInt(Review::getRating)
                .average()
                .orElse(0.0);

        return Math.round(average * 100.0) / 100.0;
    }

}
