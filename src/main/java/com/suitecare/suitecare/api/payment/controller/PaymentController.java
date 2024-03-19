package com.suitecare.suitecare.api.payment.controller;

import com.suitecare.suitecare.api.payment.dto.KakaopayRequestDTO;
import com.suitecare.suitecare.api.payment.dto.KakaopayResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path = "/api/v1/payment")
@CrossOrigin()
public class PaymentController {
    @Autowired
    KakaopayResponseDTO kakaopayResponseDTO;

    @PostMapping("/kakaopay")
    public KakaopayResponseDTO submitPayment(@RequestBody KakaopayRequestDTO kakaopayRequestDTO) {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "SECRET_KEY " + "Secret key(dev)");
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<KakaopayRequestDTO> requestEntity = new HttpEntity<>(kakaopayRequestDTO, headers);

        ResponseEntity<KakaopayResponseDTO> responseEntity = restTemplate.postForEntity(url, requestEntity, KakaopayResponseDTO.class);
        KakaopayResponseDTO responseDTO = responseEntity.getBody();

        System.out.println("Response: " + responseDTO);
        return responseDTO;
    }


}
