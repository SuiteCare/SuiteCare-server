package com.suitecare.suitecare.api.search.service;

import com.suitecare.suitecare.api.search.dto.ReservationSearchRequestDTO;
import com.suitecare.suitecare.api.search.dto.ReservationSearchResponseDTO;
import com.suitecare.suitecare.api.search.mapper.SearchMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {
    @Autowired
    SearchMapper searchMapper;

    public List<ReservationSearchResponseDTO> getReservationSearch(ReservationSearchRequestDTO requestDTO) {
        return searchMapper.getReservationSearch(requestDTO);
    }

}
