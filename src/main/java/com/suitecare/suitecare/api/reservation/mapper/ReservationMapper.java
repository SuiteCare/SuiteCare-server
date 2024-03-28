package com.suitecare.suitecare.api.reservation.mapper;

import com.suitecare.suitecare.api.recruitment.dto.ApplyInfoRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReservationMapper {
    Integer createReservation(ReservationRequestDTO reservationRequestDTO);
    Integer updateStatus(ReservationRequestDTO reservationRequestDTO);
    Integer updateStatusToReject(ApplyInfoRequestDTO applyInfoRequestDTO);
    List<FamilyReservationResponseDTO> getFamilyReservationListById(String login_id);
    List<MateReservationResponseDTO> getMateReservationListById(String login_id);
    Integer isPresentReservation(ReservationRequestDTO reservationRequestDTO);
}
