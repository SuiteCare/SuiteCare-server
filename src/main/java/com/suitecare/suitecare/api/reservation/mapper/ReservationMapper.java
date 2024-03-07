package com.suitecare.suitecare.api.reservation.mapper;

import com.suitecare.suitecare.api.reservation.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    Integer createReservation(ReservationRequestDTO reservationRequestDTO);
    Integer updateStatus(ReservationRequestDTO reservationRequestDTO);
    ReservationDetailResponseDTO getReservationInfoById(Long reservation_id);
    List<FamilyReservationResponseDTO> getFamilyReservationListById(String login_id);
    List<MateReservationResponseDTO> getMateReservationListById(String login_id);
}
