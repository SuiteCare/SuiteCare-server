package com.suitecare.suitecare.api.reservation.controller;

import com.suitecare.suitecare.api.recruitment.dto.ApplyInfoRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.FamilyReservationResponseDTO;
import com.suitecare.suitecare.api.reservation.dto.MateReservationResponseDTO;
import com.suitecare.suitecare.api.reservation.dto.ReservationRequestDTO;
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

    /* 간병 확정하기 */
    @PostMapping("/reservation")
    public Integer createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        return reservationService.createReservation(reservationRequestDTO);
    }

    /* 간병 거절하기 */
    @PatchMapping("/reject")
    public Integer updateStatusToReject(@RequestBody ApplyInfoRequestDTO applyInfoRequestDTO) {
        return reservationService.updateStatusToReject(applyInfoRequestDTO);
    }
    
    @GetMapping("/reservation/family")
    public List<FamilyReservationResponseDTO> getFamilyReservationListById(HttpServletRequest request) {
        String login_id = (String) request.getAttribute("id");
        return reservationService.getFamilyReservationListById(login_id);
    }

    @GetMapping("/reservation/mate")
    public List<MateReservationResponseDTO> getMateReservationListById(HttpServletRequest request) {
        String login_id = (String) request.getAttribute("id");
        return reservationService.getMateReservationListById(login_id);
    }

//    @GetMapping("/reservation/{id}")
//    public ReservationDetailResponseDTO getReservationInfoById(@PathVariable Long id) {
//        return reservationService.getReservationInfoById(id);
//    }
//
//    /* 예약 내역 조회 */
//    @GetMapping("/reservation")
//    public List<ReservationResponseDTO> getReservationList(HttpServletRequest request) {
//        String id= (String)request.getAttribute("id");
//        return reservationService.getReservationList(id);
//    }
}
