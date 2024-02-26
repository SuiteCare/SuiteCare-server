package com.suitecare.suitecare.api.mate_resume.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CareerDTO {
    private Long id;
    private String name;
    @JsonProperty("job_name")
    private String jobName;
    @JsonProperty("date_start")
    private LocalDate dateStart;
    @JsonProperty("date_end")
    private LocalDate dateEnd;
}
