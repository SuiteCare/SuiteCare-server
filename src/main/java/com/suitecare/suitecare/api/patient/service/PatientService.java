package com.suitecare.suitecare.api.patient.service;

import com.suitecare.suitecare.api.patient.dto.AddPatientRequestDTO;
import com.suitecare.suitecare.api.patient.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {
    @Autowired
    PatientMapper patientMapper;

    @Transactional
    public int addPatient(AddPatientRequestDTO addPatientRequestDTO){
        return patientMapper.addPatient(addPatientRequestDTO) + patientMapper.addPatientDetail(addPatientRequestDTO);
    }
}