package com.suitecare.suitecare.api.reservation.controller;

import com.suitecare.suitecare.api.reservation.dto.*;
import com.suitecare.suitecare.api.reservation.service.ReservationService;
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

    @GetMapping("/search")
    public List<SearchedReservationResponseDTO> searchReservation(SearchedReservationRequestDTO requestDTO) {
            return reservationService.getSearchedReservation(requestDTO);
    }

    @GetMapping("/pendingReservation")
    public List<PendingReservationResponseDTO> getReservationListById(@RequestParam int id) {
        return reservationService.getReservationListById(id);
    }

    @GetMapping("/reservationInfo")
    public ReservationInfoResponseDTO getReservationInfoById(@RequestParam int reservation_id) {
        return reservationService.getReservationInfoById(reservation_id);
    }

    @GetMapping("/applicant-list")
    public List<ApplicantInfoResponseDTO> getApplicantList(@RequestParam int reservation_id) {
        return reservationService.getApplicantList(reservation_id);
    }

}
