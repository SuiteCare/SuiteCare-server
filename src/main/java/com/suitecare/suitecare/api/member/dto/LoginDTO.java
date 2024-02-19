package com.suitecare.suitecare.api.member.dto;

import lombok.Data;

@Data
public class LoginDTO {
    private String id;
    private String password;
    private String role;
}
