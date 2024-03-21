package com.suitecare.suitecare.api.reservation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamilyReservationResponseDTO {
    private Long id; // 예약 ID
    private Long recruitment_id; // 공고 ID
    private String mate_resume_id; // 예약 체결된 간병인 ID
    private String mate_name; // 예약 체결된 간병인 ID
    private LocalDate confirm_at; // 예약 확정일
    private LocalDate start_date; // 간병 시작일
    private LocalDate end_date; // 간병 종료일
    private LocalTime start_time; // 간병 시작 시간
    private LocalTime end_time; // 간병 종료 시간
    private List<Integer> weekdays;
}
