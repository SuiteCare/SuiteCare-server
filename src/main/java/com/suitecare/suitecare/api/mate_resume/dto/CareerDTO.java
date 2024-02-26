package com.suitecare.suitecare.api.mate_resume.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CareerDTO {
    private Long id;
    private String name;
    @JsonProperty("job_name")
    private String job_name;
    @JsonProperty("date_start")
    private LocalDate date_start;
    @JsonProperty("date_end")
    private LocalDate date_end;
}
