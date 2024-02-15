package com.suitecare.suitecare.api.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationResponseDTO {
    private Long id; // 예약 ID
    private String mate_id; // 예약 체결된 간병인 ID
    private Long patient_id; // 예약 대상 환자 ID
    private String create_at; // 예약 신청일
    private String status; // 예약 상태
    private LocalDate start_date; // 간병 시작일
    private LocalDate end_date; // 간병 종료일
}
