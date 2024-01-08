package com.suitecare.suitecare.api.search.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class ReservationSearchResponseDTO {
    private Integer id;
    private Integer patient_id;
    private String gender;
    private LocalDate birthday;
    private String diagnosis_name;
    private String location;
    private String road_address;
    private Integer wage;
    private LocalDate start_date;
    private LocalDate end_date;
    private LocalTime start_time;
    private LocalTime end_time;
    private String day;
}
