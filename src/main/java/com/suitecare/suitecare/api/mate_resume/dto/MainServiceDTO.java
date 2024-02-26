package com.suitecare.suitecare.api.mate_resume.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MainServiceDTO {
    private Long id;
    private String name;
}
