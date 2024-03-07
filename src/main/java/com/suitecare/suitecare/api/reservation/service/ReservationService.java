package com.suitecare.suitecare.api.reservation.service;

import com.suitecare.suitecare.api.recruitment.dto.ApplyInfoRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.FamilyReservationResponseDTO;
import com.suitecare.suitecare.api.reservation.dto.MateReservationResponseDTO;
import com.suitecare.suitecare.api.reservation.dto.ReservationRequestDTO;
import com.suitecare.suitecare.api.reservation.mapper.ReservationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationMapper reservationMapper;

    @Transactional
    public Integer createReservation(ReservationRequestDTO reservationRequestDTO) {
        Integer result = reservationMapper.createReservation(reservationRequestDTO);

        if(result == 1) {
            reservationMapper.updateStatus(reservationRequestDTO);
        }

        return result;
    }

    public Integer updateStatusToReject(ApplyInfoRequestDTO applyInfoRequestDTO) {
        return reservationMapper.updateStatusToReject(applyInfoRequestDTO);
    }

    public List<FamilyReservationResponseDTO> getFamilyReservationListById(String login_id) {
        return reservationMapper.getFamilyReservationListById(login_id);
    }

    public List<MateReservationResponseDTO> getMateReservationListById(String login_id) {
        return reservationMapper.getMateReservationListById(login_id);
    }

//    public ReservationDetailResponseDTO getReservationInfoById(Long reservation_id) {
//        return reservationMapper.getReservationInfoById(reservation_id);
//    }
//
//    public List<ReservationResponseDTO> getReservationList(String id) {
//        return reservationMapper.getReservationList(id);}
}

