package com.suitecare.suitecare.api.reservation.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class DayOfReservation {
    private Long id;
    @NonNull
    private Long reservation_id;
    private Integer day;
}
