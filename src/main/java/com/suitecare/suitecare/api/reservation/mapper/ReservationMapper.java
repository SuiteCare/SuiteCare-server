package com.suitecare.suitecare.api.reservation.mapper;

import com.suitecare.suitecare.api.reservation.domain.DayOfReservation;
import com.suitecare.suitecare.api.reservation.dto.ApplyReservationRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.ReservationRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.SearchedReservationRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.SearchedReservationResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    Integer createReservation(ReservationRequestDTO reservationRequestDTO);
    void createDayOfReservation(DayOfReservation dayOfReservation);
    List<SearchedReservationResponseDTO> getSearchedReservation(SearchedReservationRequestDTO requestDTO);
    Integer applyReservation(ApplyReservationRequestDTO applyReservationRequestDTO);
    Integer getReservationIdById(ApplyReservationRequestDTO applyReservationRequestDTO);
}
