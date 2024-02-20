package com.suitecare.suitecare.api.member.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberRequestDTO {
    private String id;
    private String password;
    private String name;
    private String birthday;
    private String gender;
    private String email;
    private String tel;
    private String role;
}
