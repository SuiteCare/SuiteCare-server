package com.suitecare.suitecare.api.member.controller;

import com.suitecare.suitecare.api.custom.format.ResponseForm;
import com.suitecare.suitecare.api.member.dto.*;
import com.suitecare.suitecare.api.member.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin()
public class MemberController {
    @Autowired
    MemberService memberService;

    @GetMapping("/check/id")
    public ResponseEntity<ResponseForm> checkDuplicateID(@RequestParam String id){
        ResponseForm responseForm;

        Integer resultValue = memberService.checkDuplicateID(id);

        if(resultValue == 0) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("사용 가능한 아이디입니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.CONFLICT.value())
                    .httpStatus(HttpStatus.CONFLICT)
                    .msg("이미 사용 중인 아이디입니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    @GetMapping("/mypage")
    public ResponseEntity<ResponseForm> getMypageById(HttpServletRequest request){
        ResponseForm responseForm;
        String login_id = (String) request.getAttribute("id");

        MypageResponseDTO resultData = memberService.getMypageById(login_id);

        if(resultData != null) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("사용자의 정보가 성공적으로 조회되었습니다.")
                    .count(1)
                    .result(Collections.singletonList(resultData))
                    .build();
        }else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.NO_CONTENT.value())
                    .httpStatus(HttpStatus.NO_CONTENT)
                    .msg("요청한 사용자의 정보가 조회되지 않습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    @PostMapping("/changepassword")
    public ResponseEntity<ResponseForm> changePassword(@RequestBody ChangePasswordRequestDTO changePasswordRequestDTO, HttpServletRequest request){
        ResponseForm responseForm;
        String login_id = (String) request.getAttribute("id");

        Integer resultValue = memberService.changePassword(login_id, changePasswordRequestDTO);

        if(resultValue == 1) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("사용자의 비밀번호가 변경되었습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        } else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("서버 오류로 비밀번호 변경에 실패하였습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    @PatchMapping("/member")
    public ResponseEntity<ResponseForm> updateMember(@RequestBody UpdateMemberRequestDTO updateMemberRequestDTO, HttpServletRequest request) {
        ResponseForm responseForm;
        String login_id = (String) request.getAttribute("id");

        Integer resultValue = memberService.updateMember(login_id, updateMemberRequestDTO);

        if(resultValue == 1) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("사용자 정보가 업데이트되었습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("사용자 정보 업데이트에 실패하였습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

    @PatchMapping("/member/role")
    public ResponseEntity<ResponseForm> updateRole(HttpServletRequest request) {
        ResponseForm responseForm;
        String login_id = (String) request.getAttribute("id");

        Integer resultValue = memberService.updateRole(login_id);

        if(resultValue == 1) {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.OK.value())
                    .httpStatus(HttpStatus.OK)
                    .msg("통합회원 업데이트 완료")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }else {
            responseForm = ResponseForm.builder()
                    .code(HttpStatus.BAD_REQUEST.value())
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .msg("통합회원 업데이트에 실패하였습니다.")
                    .count(0)
                    .result(Collections.emptyList())
                    .build();
        }

        return new ResponseEntity<>(responseForm, responseForm.getHttpStatus());
    }

}
