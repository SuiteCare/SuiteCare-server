package com.suitecare.suitecare.api.reservation.dto;

import lombok.Data;

@Data
public class ApplyReservationRequestDTO {
    private Long reservation_id;
    private Long member_id;
}
