package com.suitecare.suitecare.api.reservation.controller;

import com.suitecare.suitecare.api.reservation.dto.*;
import com.suitecare.suitecare.api.reservation.service.ReservationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.suitecare.suitecare.api.patient.dto.PatientRequestDTO;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @PostMapping("/reservation")
    public Integer createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        return reservationService.create(reservationRequestDTO);
    }

    @GetMapping("/search/reservation")
    public List<SearchedReservationResponseDTO> getSearchedReservation(SearchedReservationRequestDTO requestDTO) {
            return reservationService.getSearchedReservation(requestDTO);
    }

    @PostMapping("/apply")
    public Integer applyReservation(@RequestBody ApplyReservationRequestDTO applyReservationRequestDTO) {
        return  reservationService.applyReservation(applyReservationRequestDTO);
    }
  
    @GetMapping("/pendingReservation")
    public List<PendingReservationResponseDTO> getReservationListById(@RequestParam Long id) {
        return reservationService.getReservationListById(id);
    }

    @GetMapping("/reservationInfo")
    public ReservationInfoResponseDTO getReservationInfoById(@RequestParam Long reservation_id) {
        return reservationService.getReservationInfoById(reservation_id);
    }

    @GetMapping("/applicant-list")
    public List<ApplicantInfoResponseDTO> getApplicantList(@RequestParam Long reservation_id) {
        return reservationService.getApplicantList(reservation_id);
    }
    /* 예약 내역 조회 */
    @GetMapping("/reservationHistory")
    public List<ReservationRequestDTO> getReservationList(HttpServletRequest request) {
        String login_id= (String)request.getAttribute("login_id");
        return reservationService.getReservationList(login_id);
    }
}
