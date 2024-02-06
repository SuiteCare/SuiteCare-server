package com.suitecare.suitecare.api.mate.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CareerDTO {
    private Long id;
    private String name;
    private String job_name;
    private LocalDate date_start;
    private LocalDate date_end;
}
