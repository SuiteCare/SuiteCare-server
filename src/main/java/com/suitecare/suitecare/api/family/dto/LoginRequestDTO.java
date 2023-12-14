package com.suitecare.suitecare.api.family.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO {
    private String login_id;
    private String password;
    private String role;
}
