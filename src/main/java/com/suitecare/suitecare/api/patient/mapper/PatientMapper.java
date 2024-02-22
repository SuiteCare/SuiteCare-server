package com.suitecare.suitecare.api.patient.mapper;

import com.suitecare.suitecare.api.patient.dto.PatientDetailResponseDTO;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import com.suitecare.suitecare.api.patient.dto.PatientResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientMapper {
    Integer createPatient(String login_id, PatientRequestDTO patientRequestDTO);
    Integer createPatientDetail(PatientRequestDTO patientRequestDTO);
    List<PatientRequestDTO> getPatientList(String id);
    PatientResponseDTO getPatient(String id);
    PatientDetailResponseDTO getPatientDetail(String id);
    Integer updatePatient(PatientRequestDTO patientRequestDTO);
    Integer updatePatientDetail(PatientRequestDTO patientRequestDTO);
}
