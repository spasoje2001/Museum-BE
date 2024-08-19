package com.veljko121.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExhibitionProposalDTO {
    @NotBlank(message = "Start date is required.")
    private String startDate;
    @NotBlank(message = "End date is required.")
    private String endDate;
    @NotNull(message = "Price is required.")
    @Positive(message = "Price must be positive.")
    private BigDecimal adultPrice;
    @NotNull(message = "Price for children is required.")
    @Positive(message = "Price for children must be positive.")
    private BigDecimal minorPrice;
    @NotNull(message = "Room ID is required.")
    private Integer roomId;
    @NotNull(message = "Organizer ID is required.")
    private Integer organizerId;
}
