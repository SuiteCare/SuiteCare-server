package com.suitecare.suitecare.api.reservation.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PendingReservationResponseDTO {
    private Long reservation_id;
    private Long patient_id;
    private LocalDate start_date;
    private LocalDate end_date;
}
