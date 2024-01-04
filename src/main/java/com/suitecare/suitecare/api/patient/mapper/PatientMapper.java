package com.suitecare.suitecare.api.patient.mapper;

import com.suitecare.suitecare.api.patient.dto.PatientDetailResponseDTO;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import com.suitecare.suitecare.api.patient.dto.PatientResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientMapper {
    Integer addPatient(PatientRequestDTO patientRequestDTO);
    Integer addPatientDetail(PatientRequestDTO patientRequestDTO);
    List<PatientRequestDTO> getPatientList(String id);
    PatientResponseDTO getPatient(String id);
    PatientDetailResponseDTO getPatientDetail(String id);
}
