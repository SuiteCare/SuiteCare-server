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
        int addPatient = patientMapper.addPatient(addPatientRequestDTO);
        String patientID = patientMapper.getPatientID(addPatientRequestDTO);

        if (addPatient == 1) {
            addPatientRequestDTO.setId(patientID);
            int addPatientDetail = patientMapper.addPatientDetail(addPatientRequestDTO);
            return addPatientDetail > 0 ? 2 : 1;
        }

        return 0;
    }

    @Transactional
    public AddPatientRequestDTO[] getPatientList(String id){
        return patientMapper.getPatientList(id);
    }

}
