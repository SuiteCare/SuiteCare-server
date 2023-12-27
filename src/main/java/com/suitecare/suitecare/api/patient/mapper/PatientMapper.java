package com.suitecare.suitecare.api.patient.mapper;

import com.suitecare.suitecare.api.patient.dto.AddPatientRequestDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientMapper {
    int addPatient(AddPatientRequestDTO addPatientRequestDTO);
    int addPatientDetail(AddPatientRequestDTO addPatientRequestDTO);
}
