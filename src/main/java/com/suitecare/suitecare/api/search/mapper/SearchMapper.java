package com.suitecare.suitecare.api.search.mapper;

import com.suitecare.suitecare.api.search.dto.ReservationSearchRequestDTO;
import com.suitecare.suitecare.api.search.dto.ReservationSearchResponseDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SearchMapper {
    List<ReservationSearchResponseDTO> getReservationSearch(ReservationSearchRequestDTO requestDTO);
}
