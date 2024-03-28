package com.suitecare.suitecare.patient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class PatientTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;

    @DisplayName("환자 생성 테스트")
    @Test
    void createPatient() throws Exception {

        // given
        PatientRequestDTO patientRequestDTO = PatientRequestDTO.builder()
                                                .id(1L)
                                                .name("Jisung Hwang")
                                                .gender("F")
                                                .birthday(LocalDate.of(1993, 2, 3))
                                                .height("170")
                                                .weight("60")
                                                .diagnosis_name("당뇨")
                                                .consciousness_state("의식 있음")
                                                .paralysis_state("없음")
                                                .behavioral_state("스스로 걸을 수 있음")
                                                .meal_care_state("스스로 식사 가능")
                                                .toilet_care_state("스스로 화장실 이용")
                                                .is_bedsore("N")
                                                .need_suction("N")
                                                .need_outpatient("N")
                                                .need_night_care("N")
                                                .notice("")
                                                .build();

        // when
        final ResultActions perform = mockMvc.perform(post("/api/v1/patient")
                .content(objectMapper.writeValueAsString(patientRequestDTO))
                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(status().isOk())
                .andExpect(content().string(String.valueOf(1)))
                .andDo(print());

    }
}
