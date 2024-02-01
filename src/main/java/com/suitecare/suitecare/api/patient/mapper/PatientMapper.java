package com.suitecare.suitecare.api.patient.mapper;

import com.suitecare.suitecare.api.patient.dto.PatientDetailResponseDTO;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import com.suitecare.suitecare.api.patient.dto.PatientResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface PatientMapper {
    Integer createPatient(Map<String, Object> parameterMap);
    Integer createPatientDetail(Map<String, Object> parameterMap);
    List<PatientRequestDTO> getPatientList(String id);
    PatientResponseDTO getPatient(String id);
    PatientDetailResponseDTO getPatientDetail(String id);
}
