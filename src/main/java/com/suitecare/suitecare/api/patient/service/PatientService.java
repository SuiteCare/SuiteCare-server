package com.suitecare.suitecare.api.patient.service;

import com.suitecare.suitecare.api.patient.dto.PatientDetailRequestDTO;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import com.suitecare.suitecare.api.patient.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PatientService {
    @Autowired
    PatientMapper patientMapper;

    @Transactional
    public int addPatient(PatientRequestDTO patientRequestDTO){
        int addPatient = patientMapper.addPatient(patientRequestDTO);
        String patientID = patientMapper.getPatientID(patientRequestDTO);

        if (addPatient == 1) {
            patientRequestDTO.setId(patientID);
            int addPatientDetail = patientMapper.addPatientDetail(patientRequestDTO);
            return addPatientDetail > 0 ? 2 : 1;
        }

        return 0;
    }

    @Transactional
    public PatientRequestDTO[] getPatientList(String id){
        return patientMapper.getPatientList(id);
    }

    @Transactional
    public PatientRequestDTO getPatientBasic(String id){
        return patientMapper.getPatientBasic(id);
    }

    @Transactional
    public PatientDetailRequestDTO getPatientDetail(String id){
        return patientMapper.getPatientDetail(id);
    }

}
