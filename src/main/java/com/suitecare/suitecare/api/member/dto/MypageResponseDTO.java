package com.suitecare.suitecare.api.member.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MypageResponseDTO {
    private String id;
    private String name;
    private String gender;
    private LocalDate birthday;
    private String tel;
    private String email;
}
