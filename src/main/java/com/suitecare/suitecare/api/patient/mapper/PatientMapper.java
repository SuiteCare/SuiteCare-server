package com.suitecare.suitecare.api.patient.mapper;

import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientMapper {
    int addPatient(PatientRequestDTO patientRequestDTO);
    int addPatientDetail(PatientRequestDTO patientRequestDTO);
    String getPatientID(PatientRequestDTO patientRequestDTO);
    PatientRequestDTO[] getPatientList(String id);
    PatientRequestDTO getPatientDetail(String id);
}
