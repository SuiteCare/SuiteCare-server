package com.suitecare.suitecare.api.patient.controller;

import com.suitecare.suitecare.api.patient.dto.PatientDetailRequestDTO;
import com.suitecare.suitecare.api.patient.service.PatientService;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("/patient")
    public List<PatientRequestDTO> getPatientList(@RequestParam String id){
        return patientService.getPatientList(id);
    }

    @PostMapping("/patient")
    public int addPatient(@RequestBody PatientRequestDTO patientRequestDTO, @RequestBody PatientDetailRequestDTO patientDetailRequestDTO){

        return patientService.addPatient(patientRequestDTO);
    }

    @GetMapping("/patient/{id}")
    public PatientRequestDTO getPatientBasic(@PathVariable String id){
        return patientService.getPatientBasic(id);
    }

    @GetMapping("/patientDetail/{id}")
    public PatientDetailRequestDTO getPatientDetail(@PathVariable String id){
        return patientService.getPatientDetail(id);
    }
}
