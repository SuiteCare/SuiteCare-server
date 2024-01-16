package com.suitecare.suitecare.api.reservation.controller;

import com.suitecare.suitecare.api.reservation.dto.ApplyReservationRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.ReservationRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.SearchedReservationRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.SearchedReservationResponseDTO;
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

    @GetMapping("/mate/search")
    public List<SearchedReservationResponseDTO> searchReservation(SearchedReservationRequestDTO requestDTO) {
            return reservationService.getSearchedReservation(requestDTO);
    }

    @PostMapping("/apply")
    public Integer applyReservation(@RequestBody ApplyReservationRequestDTO applyReservationRequestDTO) {
        return  reservationService.applyReservation(applyReservationRequestDTO);
    }
}
