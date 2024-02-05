package com.suitecare.suitecare.api.patient.service;

import com.suitecare.suitecare.api.patient.dto.PatientDetailResponseDTO;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;
import com.suitecare.suitecare.api.patient.dto.PatientResponseDTO;
import com.suitecare.suitecare.api.patient.mapper.PatientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientService {
    @Autowired
    PatientMapper patientMapper;

    /* 환자 목록 조회 */
    @Transactional
    public List<PatientRequestDTO> getPatientList(String login_id){
        return patientMapper.getPatientList(login_id);
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
    public int createPatient(String login_id, PatientRequestDTO patientRequestDTO){
        // Patient 를 생성하려는 회원이 family 회원이 맞는지 검증 필요

        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("login_id", login_id);
        parameterMap.put("patient", patientRequestDTO);

        // Patient 레코드 생성
        Integer addPatientCount = patientMapper.createPatient(parameterMap);

        // Patient 레코드가 정상적으로 생성되었다면, PatientDetail 레코드 생성
        if (addPatientCount == 1) {
            return patientMapper.createPatientDetail(parameterMap);
        }

        return 0;
    }

    /* 환자 정보 수정 */
    public int updatePatient(PatientRequestDTO patientRequestDTO) {
        if(patientMapper.updatePatient(patientRequestDTO) == 1) {
            return patientMapper.updatePatientDetail(patientRequestDTO);
        }

        return 0;
    }
}
