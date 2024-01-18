package com.suitecare.suitecare.api.reservation.service;

import com.suitecare.suitecare.api.mate.mapper.MateMapper;
import com.suitecare.suitecare.api.reservation.domain.DayOfReservation;
import com.suitecare.suitecare.api.reservation.dto.ApplyReservationRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.ReservationRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.SearchedReservationRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.SearchedReservationResponseDTO;
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

    public Integer applyReservation(ApplyReservationRequestDTO applyReservationRequestDTO) {
//        if(mateMapper.getMateprofileById(applyReservationRequestDTO.getMember_id()) != null) {
            if(reservationMapper.getReservationIdById(applyReservationRequestDTO) == null) {
                return reservationMapper.applyReservation(applyReservationRequestDTO);
            }
            return 2;
//        }
//        return 0;
    }
}
