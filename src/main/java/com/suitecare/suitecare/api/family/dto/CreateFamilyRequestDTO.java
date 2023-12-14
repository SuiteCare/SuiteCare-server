package com.suitecare.suitecare.api.family.dto;

import lombok.Data;

@Data
public class CreateFamilyRequestDTO {
    private String id;
    private String password;
    private String name;
    private String tel;
}
