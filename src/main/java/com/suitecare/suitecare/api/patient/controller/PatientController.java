package com.suitecare.suitecare.api.patient.controller;

import com.suitecare.suitecare.api.patient.dto.PatientDetailResponseDTO;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import com.suitecare.suitecare.api.patient.dto.PatientResponseDTO;
import com.suitecare.suitecare.api.patient.service.PatientService;
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
    public List<PatientRequestDTO> getPatientList(@RequestParam String id){
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
    public int createPatient(@RequestBody PatientRequestDTO patientRequestDTO){

        return patientService.createPatient(patientRequestDTO);
    }

}
