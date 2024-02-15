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
    
    public Integer applyReservation(String login_id, ApplyReservationRequestDTO applyReservationRequestDTO) {
        if(!isPresentResume(login_id)) {
            return 0;
        }

        Long reservation_id = applyReservationRequestDTO.getReservation_id();

        if(!isPresentApplicant(login_id, reservation_id)) {
            return reservationMapper.applyReservation(login_id, reservation_id);
        }

        return 2;
    }

    public boolean isPresentResume(String login_id) { // 간병인 이력서 여부
        return mateMapper.isPresentResume(login_id) != null;
    }

    public boolean isPresentApplicant(String login_id, Long reservation_id) { // 지원 여부
        return reservationMapper.isPresentApplicant(login_id, reservation_id) != 0;
    }
  
    public List<PendingReservationResponseDTO> getReservationListById(String login_id) {
        return reservationMapper.getReservationListById(login_id);
    }

    public ReservationDetailResponseDTO getReservationInfoById(Long reservation_id) {
        return reservationMapper.getReservationInfoById(reservation_id);
    }

    public List<ApplicantInfoResponseDTO> getApplicantList(Long reservation_id) {
        return reservationMapper.getApplicantList(reservation_id);
    }


    public List<ReservationResponseDTO> getReservationList(String login_id) {
        return reservationMapper.getReservationList(login_id);}
}

