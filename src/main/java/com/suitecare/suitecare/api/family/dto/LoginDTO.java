package com.suitecare.suitecare.api.family.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {
    private String suite_family_id;
    private String password;
    private String role;
}
