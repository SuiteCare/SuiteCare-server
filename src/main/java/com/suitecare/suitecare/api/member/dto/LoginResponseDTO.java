package com.suitecare.suitecare.api.member.dto;

import lombok.Data;

@Data
public class LoginResponseDTO {
    private String password;
    private Integer id;
}
