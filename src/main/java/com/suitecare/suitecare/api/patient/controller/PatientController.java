package com.suitecare.suitecare.api.patient.controller;

import com.suitecare.suitecare.api.patient.dto.PatientDetailResponseDTO;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import com.suitecare.suitecare.api.patient.dto.PatientResponseDTO;
import com.suitecare.suitecare.api.patient.service.PatientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
public class PatientController {
    @Autowired
    PatientService patientService;

    /* 환자 목록 조회 */
    @GetMapping("/patient")
    public List<PatientRequestDTO> getPatientList(HttpServletRequest request){
        String id = (String) request.getAttribute("id");
        return patientService.getPatientList(id);
    }

    /* 환자 기본 조회 */
    @GetMapping("/patient/{id}")
    public PatientResponseDTO getPatient(@PathVariable String id){
        return patientService.getPatient(id);
    }

    /* 환자 상세 조회 */
    @GetMapping("/patientDetail/{id}")
    public PatientDetailResponseDTO getPatientDetail(@PathVariable String id){
        return patientService.getPatientDetail(id);
    }

    /* 환자 등록 */
    @PostMapping("/patient")
    public int createPatient(@RequestBody PatientRequestDTO patientRequestDTO, HttpServletRequest request){
        String login_id = (String)request.getAttribute("id");
        return patientService.createPatient(login_id, patientRequestDTO);
    }

    /* 환자 정보 수정 */
    @PatchMapping("/patient/{id}")
    public int updatePatient(@PathVariable Long id, @RequestBody PatientRequestDTO patientRequestDTO) {
        patientRequestDTO.setId(id);
        return patientService.updatePatient(patientRequestDTO);
    }

    @DeleteMapping("/patient/{id}")
    public int deletePatient(@PathVariable Long id, HttpServletRequest requet) {
        String login_id = (String)requet.getAttribute("id");
        return patientService.deletePatient(id, login_id);
    }
}
