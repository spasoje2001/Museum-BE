package com.veljko121.backend.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ExhibitionPriceListResponseDTO {
    private BigDecimal adultPrice;
    private BigDecimal minorPrice;
}
