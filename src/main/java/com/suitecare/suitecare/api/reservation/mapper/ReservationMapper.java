package com.suitecare.suitecare.api.reservation.mapper;

import com.suitecare.suitecare.api.reservation.domain.DayOfReservation;
import com.suitecare.suitecare.api.reservation.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    Integer createReservation(ReservationRequestDTO reservationRequestDTO);
    void createDayOfReservation(DayOfReservation dayOfReservation);
    List<SearchedReservationResponseDTO> getSearchedReservation(SearchedReservationRequestDTO requestDTO);
    List<PendingReservationResponseDTO> getReservationListById(int id);
    ReservationInfoResponseDTO getReservationInfoById(int reservation_id);
    List<ApplicantInfoResponseDTO> getApplicantList(int reservation_id);
}
