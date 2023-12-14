package com.suitecare.suitecare.api.family.dto;

import lombok.Data;

@Data
public class CreateFamilyRequestDTO {
    private String login_id;
    private String password;
    private String name;
    private String tel;
    private String role;
}
