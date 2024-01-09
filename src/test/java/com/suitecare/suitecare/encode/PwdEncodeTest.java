package com.suitecare.suitecare.encode;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suitecare.suitecare.api.member.dto.CreateMemberRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PwdEncodeTest {

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void pwdEnc() throws Exception {
        CreateMemberRequestDTO createMemberRequestDTO = CreateMemberRequestDTO.builder()
                .login_id("dool")
                .name("dool")
                .password("dool")
                .tel("01012341234")
                .role("F")
                .build();

        // when
        final ResultActions perform = mockMvc.perform(post("/api/v1/member")
                .content(objectMapper.writeValueAsString(createMemberRequestDTO))
                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(1)))
                .andDo(print());

    }
}
