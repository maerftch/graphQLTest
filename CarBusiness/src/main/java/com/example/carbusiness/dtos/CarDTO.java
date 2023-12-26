package com.example.carbusiness.dtos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CarDTO {
    String model,color,matricul;
    Float price;

}
