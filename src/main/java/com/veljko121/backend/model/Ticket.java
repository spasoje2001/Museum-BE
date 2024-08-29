package com.veljko121.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "exhibition_id", nullable = false)
    private Exhibition exhibition;

    @Column(name = "number_of_adults", nullable = false)
    private int numberOfAdults;

    @Column(name = "number_of_minors", nullable = false)
    private int numberOfMinors;

    @Column(name = "total_price", nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne // Veza sa posetiocem, mnoge karte mogu biti kupljene od strane jednog posetioca
    @JoinColumn(name = "guest_id", nullable = false) // Strani ključ za posetioca
    private Guest guest;

    // Konstruktor bez argumenata potreban za JPA
    public Ticket() {
    }

    // Konstruktor sa svim parametrima
    public Ticket(Integer id, Exhibition exhibition, int numberOfAdults, int numberOfMinors, BigDecimal totalPrice, Guest guest) {
        this.id = id;
        this.exhibition = exhibition;
        this.numberOfAdults = numberOfAdults;
        this.numberOfMinors = numberOfMinors;
        this.totalPrice = totalPrice;
        this.guest = guest;
    }

    // Metoda za izračunavanje ukupne cene na osnovu cenovnika i broja odraslih i dece
    public void calculateTotalPrice(ExhibitionPriceList priceList) {
        BigDecimal adultsPrice = priceList.getAdultTicketPrice().multiply(new BigDecimal(numberOfAdults));
        BigDecimal childrenPrice = priceList.getMinorTicketPrice().multiply(new BigDecimal(numberOfMinors));
        this.totalPrice = adultsPrice.add(childrenPrice);
    }

}
