package com.suitecare.suitecare.api.reservation.controller;

import com.suitecare.suitecare.api.reservation.dto.*;
import com.suitecare.suitecare.api.reservation.service.ReservationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

//    @PostMapping("/apply")
//    public Integer applyReservation(HttpServletRequest request, @RequestBody ApplyReservationRequestDTO applyReservationRequestDTO) {
//        String id = (String) request.getAttribute("id");
//        return  reservationService.applyReservation(id, applyReservationRequestDTO);
//    }
  
    @GetMapping("/pendingReservation")
    public List<PendingReservationResponseDTO> getReservationListById(HttpServletRequest request) {
        String id = (String)request.getAttribute("id");
        return reservationService.getReservationListById(id);
    }

    @GetMapping("/reservation/{id}")
    public ReservationDetailResponseDTO getReservationInfoById(@PathVariable Long id) {
        return reservationService.getReservationInfoById(id);
    }

    @GetMapping("/applicant-list")
    public List<ApplicantInfoResponseDTO> getApplicantList(@RequestParam Long reservation_id) {
        return reservationService.getApplicantList(reservation_id);
    }
    /* 예약 내역 조회 */
    @GetMapping("/reservation")
    public List<ReservationResponseDTO> getReservationList(HttpServletRequest request) {
        String id= (String)request.getAttribute("id");
        return reservationService.getReservationList(id);
    }
}
