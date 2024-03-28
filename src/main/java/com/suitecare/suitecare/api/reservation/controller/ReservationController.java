package com.suitecare.suitecare.api.reservation.controller;

import com.suitecare.suitecare.api.custom.format.ResponseForm;
import com.suitecare.suitecare.api.recruitment.dto.ApplyInfoRequestDTO;
import com.suitecare.suitecare.api.reservation.dto.FamilyReservationResponseDTO;
import com.suitecare.suitecare.api.reservation.dto.MateReservationResponseDTO;
import com.suitecare.suitecare.api.reservation.dto.ReservationRequestDTO;
import com.suitecare.suitecare.api.reservation.service.ReservationService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    /* 간병 확정하기 */
    @PostMapping("/reservation")
    public ResponseEntity<ResponseForm> createReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        ResponseForm responseForm;

        int result = reservationService.createReservation(reservationRequestDTO);

        if(result != 0) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("간병이 확정되었습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("간병 확정에 실패했습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 간병 거절하기 */
    @PatchMapping("/reject")
    public ResponseEntity<ResponseForm> updateStatusToReject(@RequestBody ApplyInfoRequestDTO applyInfoRequestDTO) {
        ResponseForm responseForm;

        int result = reservationService.updateStatusToReject(applyInfoRequestDTO);

        if(result != 0) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("해당 지원 거절")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("거절 실패")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 보호자의 예약 내역 */
    @GetMapping("/reservation/family")
    public ResponseEntity<ResponseForm> getFamilyReservationListById(HttpServletRequest request) {
        ResponseForm responseForm;

        String login_id = (String) request.getAttribute("id");

        List<FamilyReservationResponseDTO> reservationList = reservationService.getFamilyReservationListById(login_id);
        List<Object> result = new ArrayList<>(reservationList);
        int listSize = result.size();

        if(listSize != 0) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("예약 목록이 조회되었습니다.")
                    .count(listSize)
                    .result(result)
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    /* 간병인의 예약 내역 */
    @GetMapping("/reservation/mate")
    public ResponseEntity<ResponseForm> getMateReservationListById(HttpServletRequest request) {
        ResponseForm responseForm;

        String login_id = (String) request.getAttribute("id");

        List<MateReservationResponseDTO> reservationList = reservationService.getMateReservationListById(login_id);
        List<Object> result = new ArrayList<>(reservationList);
        int listSize = result.size();

        if(listSize != 0) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("예약 목록이 조회되었습니다.")
                    .count(listSize)
                    .result(result)
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }
}
