package com.suitecare.suitecare.api.recruitment.dto;

import lombok.Data;

@Data
public class ApplyToMateRequestDTO {
    private Long recruitment_id;
    private String mate_id;
}