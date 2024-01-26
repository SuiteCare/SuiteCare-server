package com.suitecare.suitecare.api.mate.dto;

import lombok.Data;

@Data
public class MateDTO {
    private String profile_picture_filename;
    private String introduction;
    private String contact_time_start;
    private String contact_time_end;
    private Integer desired_wage;
}
