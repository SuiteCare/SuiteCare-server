package com.suitecare.suitecare.api.patient.controller;

import com.suitecare.suitecare.api.custom.format.ResponseForm;
import com.suitecare.suitecare.api.patient.dto.PatientDetailResponseDTO;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import com.suitecare.suitecare.api.patient.dto.PatientResponseDTO;
import com.suitecare.suitecare.api.patient.service.PatientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
public class PatientController { // 오류 났을 때의 상태도 추가해야하지않나 고민듕
    @Autowired
    PatientService patientService;

    /* 환자 목록 조회 */
    @GetMapping("/patient")
    public ResponseEntity<ResponseForm> getPatientList(HttpServletRequest request){
        ResponseForm responseForm;
        String login_id = (String) request.getAttribute("id");

        List<PatientRequestDTO> patientList = patientService.getPatientList(login_id);

        List<Object> result = new ArrayList<>(patientList);
        int listSize = result.size();

        if(listSize != 0) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("사용자의 환자 목록이 조회되었습니다.")
                    .count(listSize)
                    .result(result)
                    .build();
        }else {
            responseForm = ResponseForm.builder()
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());

    }

    /* 환자 기본 조회 */
    @GetMapping("/patient/{id}")
    public ResponseEntity<ResponseForm> getPatient(@PathVariable String id){
        ResponseForm responseForm;

        PatientResponseDTO patient = patientService.getPatient(id);

        if(patient != null) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .count(1)
                    .msg("요청하신 환자 정보가 조회되었습니다.")
                    .result(Collections.singletonList(patient))
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 환자 상세 조회 */
    @GetMapping("/patientDetail/{id}")
    public ResponseEntity<ResponseForm> getPatientDetail(@PathVariable String id){
        ResponseForm responseForm;

        PatientDetailResponseDTO patientDetail = patientService.getPatientDetail(id);

        if(patientDetail != null) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .count(1)
                    .msg("요청하신 환자 상세정보가 조회되었습니다.")
                    .result(Collections.singletonList(patientDetail))
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());

    }

    /* 환자 등록 */
    @PostMapping("/patient")
    public ResponseEntity<ResponseForm> createPatient(@RequestBody PatientRequestDTO patientRequestDTO, HttpServletRequest request){
        ResponseForm responseForm;
        String login_id = (String)request.getAttribute("id");

        int result = patientService.createPatient(login_id, patientRequestDTO);

        if(result == 1) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("환자 등록이 완료되었습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("환자 등록에 실패했습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 환자 정보 수정 */
    @PatchMapping("/patient/{id}")
    public ResponseEntity<ResponseForm> updatePatient(@PathVariable Long id, @RequestBody PatientRequestDTO patientRequestDTO) {
        ResponseForm responseForm;
        patientRequestDTO.setId(id);

        int result = patientService.updatePatient(patientRequestDTO);

        if(result == 1) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("환자 정보가 수정되었습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("환자 정보 수정에 실패했습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<ResponseForm> deletePatient(@PathVariable Long id, HttpServletRequest request) {
        ResponseForm responseForm;
        String login_id = (String)request.getAttribute("id");

        int result = patientService.deletePatient(id, login_id);

        if(result == 1) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("환자 정보가 삭제되었습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("환자 정보 삭제에 실패했습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }
}
