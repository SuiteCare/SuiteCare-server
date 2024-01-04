package com.suitecare.suitecare.api.patient.service;

import com.suitecare.suitecare.api.patient.dto.PatientDetailResponseDTO;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import com.suitecare.suitecare.api.patient.dto.PatientResponseDTO;
import com.suitecare.suitecare.api.patient.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientMapper patientMapper;

    /* 환자 목록 조회 */
    @Transactional
    public List<PatientRequestDTO> getPatientList(String id){
        return patientMapper.getPatientList(id);
    }

    /* 환자 조회 */
    @Transactional
    public PatientResponseDTO getPatient(String id){
        return patientMapper.getPatient(id);
    }

    /* 환자 상세 조회 */
    @Transactional
    public PatientDetailResponseDTO getPatientDetail(String id){
        return patientMapper.getPatientDetail(id);
    }

    /* 환자 추가 */
    @Transactional
    public int createPatient(PatientRequestDTO patientRequestDTO){
        // Patient 를 생성하려는 회원이 family 회원이 맞는지 검증 필요

        // Patient 레코드 생성
        Integer addPatientCount = patientMapper.createPatient(patientRequestDTO);

        // Patient 레코드가 정상적으로 생성되었다면, PatientDetail 레코드 생성
        if (addPatientCount == 1) {
            return patientMapper.createPatientDetail(patientRequestDTO);
        }

        return 0;
    }

}
