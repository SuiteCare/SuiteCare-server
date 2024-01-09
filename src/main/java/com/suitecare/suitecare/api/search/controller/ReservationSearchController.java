package com.suitecare.suitecare.api.search.controller;

import com.suitecare.suitecare.api.search.dto.ReservationSearchRequestDTO;
import com.suitecare.suitecare.api.search.dto.ReservationSearchResponseDTO;
import com.suitecare.suitecare.api.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1")
@CrossOrigin
public class ReservationSearchController {
    @Autowired
    SearchService searchService;

    @GetMapping("/search-reservation")
    public List<ReservationSearchResponseDTO> search(ReservationSearchRequestDTO requestDTO) {
        return searchService.getReservationSearch(requestDTO);
    }
}
