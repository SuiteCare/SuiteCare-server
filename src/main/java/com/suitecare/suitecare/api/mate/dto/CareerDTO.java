package com.suitecare.suitecare.api.mate.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class CareerDTO {
    private Long id;
    private String name;
    private String job_name;
    private Date date_start;
    private Date date_end;
}
