package com.veljko121.backend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "exhibition_pricelist")
public class ExhibitionPriceList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(nullable = false)
    private BigDecimal adultTicketPrice;

    @NotNull
    @Column(nullable = false)
    private BigDecimal minorTicketPrice;
}
