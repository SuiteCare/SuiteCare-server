package com.suitecare.suitecare.api.mate_resume.dto;

import com.suitecare.suitecare.api.custom.ifc.HasIdNDeletable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CareerDTO implements HasIdNDeletable {
    private Long id;
    private String name;
    private String job_name;
    private LocalDate date_start;
    private LocalDate date_end;
    private Boolean isDeleted;
}
