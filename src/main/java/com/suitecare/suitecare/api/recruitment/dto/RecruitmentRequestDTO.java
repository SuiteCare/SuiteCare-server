package com.suitecare.suitecare.api.recruitment.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class RecruitmentRequestDTO {
    private Long id;
    private Long patient_id;
    // 간병 지역
    private String location;
    // 간병 지역 우편번호
    private String postcode;
    // 간병 지역 도로명주소
    private String road_address;
    // 간병 지역 지번주소
    private String jibun_address;
    // 간병 지역 상세주소
    private String address_detail;
    // 급여
    private Integer wage;
    // 간병 시작일
    private LocalDate start_date;
    // 간병 종료일
    private LocalDate end_date;
    // 요일
    private List<Integer> weekday;
    // 간병 시작시간
    private LocalTime start_time;
    // 간병 종료시간
    private LocalTime end_time;
    // 간병 종료시간
    private Timestamp expire_at;
    // 예약 상태
    private String status;
}
