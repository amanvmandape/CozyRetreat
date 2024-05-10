package com.cozyretreat.payload;

import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDTO {
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
}
