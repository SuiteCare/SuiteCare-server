package com.suitecare.suitecare.api.patient.controller;

import com.suitecare.suitecare.api.patient.service.PatientService;
import com.suitecare.suitecare.api.patient.dto.AddPatientRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
public class PatientController {
    @Autowired
    PatientService patientService;

    @PostMapping("/patient")
    public int addPatient(@RequestBody AddPatientRequestDTO addPatientRequestDTO){
        return patientService.addPatient(addPatientRequestDTO);
    }

    @GetMapping("/patient")
    public AddPatientRequestDTO[] getPatientList(@RequestParam String id){
        return patientService.getPatientList(id);
    }
}
