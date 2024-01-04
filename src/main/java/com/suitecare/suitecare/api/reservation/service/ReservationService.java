package com.suitecare.suitecare.api.reservation.service;

import com.suitecare.suitecare.api.reservation.domain.DayOfReservation;
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
}
