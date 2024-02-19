package com.suitecare.suitecare.api.reservation.service;

import com.suitecare.suitecare.api.mate.mapper.MateMapper;
import com.suitecare.suitecare.api.reservation.domain.DayOfReservation;
import com.suitecare.suitecare.api.reservation.dto.*;
import com.suitecare.suitecare.api.reservation.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationMapper reservationMapper;

    @Autowired
    MateMapper mateMapper;

    @Transactional
    public Integer create(ReservationRequestDTO reservationRequestDTO) {
        Integer result = reservationMapper.createReservation(reservationRequestDTO);
        DayOfReservation dayOfReservation = new DayOfReservation(reservationRequestDTO.getId());
        List<Integer> weekday = reservationRequestDTO.getWeekday();

        if(!weekday.isEmpty()){
            for (Integer integer : weekday) {
                dayOfReservation.setDay(integer);
                reservationMapper.createDayOfReservation(dayOfReservation);
            }
        }

        return result;

    }

    public List<SearchedReservationResponseDTO> getSearchedReservation(SearchedReservationRequestDTO requestDTO) {
        return reservationMapper.getSearchedReservation(requestDTO);
    }
    
    public Integer applyReservation(String id, ApplyReservationRequestDTO applyReservationRequestDTO) {
        if(!isPresentResume(id)) {
            return 0;
        }

        Long reservation_id = applyReservationRequestDTO.getReservation_id();

        if(!isPresentApplicant(id, reservation_id)) {
            return reservationMapper.applyReservation(id, reservation_id);
        }

        return 2;
    }

    public boolean isPresentResume(String id) { // 간병인 이력서 여부
        return mateMapper.isPresentResume(id) != null;
    }

    public boolean isPresentApplicant(String id, Long reservation_id) { // 지원 여부
        return reservationMapper.isPresentApplicant(id, reservation_id) != 0;
    }
  
    public List<PendingReservationResponseDTO> getReservationListById(String id) {
        return reservationMapper.getReservationListById(id);
    }

    public ReservationDetailResponseDTO getReservationInfoById(Long reservation_id) {
        return reservationMapper.getReservationInfoById(reservation_id);
    }

    public List<ApplicantInfoResponseDTO> getApplicantList(Long reservation_id) {
        return reservationMapper.getApplicantList(reservation_id);
    }


    public List<ReservationResponseDTO> getReservationList(String id) {
        return reservationMapper.getReservationList(id);}
}

