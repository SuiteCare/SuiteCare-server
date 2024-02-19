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
    Integer applyReservation(String id, Long reservation_id);
    Integer isPresentApplicant(String id, Long reservation_id);
    List<PendingReservationResponseDTO> getReservationListById(String id);
    ReservationDetailResponseDTO getReservationInfoById(Long reservation_id);
    List<ApplicantInfoResponseDTO> getApplicantList(Long reservation_id);
    List<ReservationResponseDTO> getReservationList(String id);
}
