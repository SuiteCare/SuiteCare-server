package com.suitecare.suitecare.api.member.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateMemberRequestDTO {
    private String login_id;
    private String password;
    private String name;
    private String tel;
    private String role;
}
