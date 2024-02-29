package com.suitecare.suitecare.api.patient.mapper;

import com.suitecare.suitecare.api.patient.dto.PatientDetailResponseDTO;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import com.suitecare.suitecare.api.patient.dto.PatientResponseDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PatientMapper {
    Integer createPatient(@Param("login_id") String login_id, @Param("patientRequestDTO") PatientRequestDTO patientRequestDTO);
    Integer createPatientDetail(PatientRequestDTO patientRequestDTO);
    List<PatientRequestDTO> getPatientList(String login_id);
    PatientResponseDTO getPatient(String id);
    PatientDetailResponseDTO getPatientDetail(String id);
    Integer updatePatient(PatientRequestDTO patientRequestDTO);
    Integer updatePatientDetail(PatientRequestDTO patientRequestDTO);
    Integer deletePatient(@Param("id") Long id, @Param("login_id") String login_id);
}
