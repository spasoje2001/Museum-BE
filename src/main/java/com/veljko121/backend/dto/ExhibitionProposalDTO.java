package com.veljko121.backend.dto;

import com.veljko121.backend.model.ExhibitionPriceList;
import com.veljko121.backend.model.Organizer;
import com.veljko121.backend.model.RoomReservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

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



