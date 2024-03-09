package com.suitecare.suitecare.api.mate_resume.dto;

import lombok.Data;

@Data
public class SearchedMateRequestDTO {
    private String search_name;
    private String search_diagnosis;
    private String[] location;
    private String[] gender;
    private String[] service;
    private String[] age;
    private Integer[] wage;
}
