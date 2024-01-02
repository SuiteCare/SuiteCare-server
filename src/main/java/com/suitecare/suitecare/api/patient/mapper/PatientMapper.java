package com.suitecare.suitecare.api.patient.mapper;

import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientMapper {
    Integer addPatient(PatientRequestDTO patientRequestDTO);
    Integer addPatientDetail(PatientRequestDTO patientRequestDTO);
    List<PatientRequestDTO> getPatientList(String id);
    PatientRequestDTO getPatientDetail(String id);
}
