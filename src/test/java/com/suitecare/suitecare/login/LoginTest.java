package com.suitecare.suitecare.login;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class LoginTest {

    @Autowired MockMvc mockMvc;

    @Test
    void 로그인() throws Exception {

        mockMvc.perform(post("/api/v1/login")
                .param("suite_family_id", "Kim")
                .param("password", "Kim")
                .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(status().isOk())
                .andExpect(redirectedUrl("/family/login"))
                .andDo(System.out::println);

    }
}
