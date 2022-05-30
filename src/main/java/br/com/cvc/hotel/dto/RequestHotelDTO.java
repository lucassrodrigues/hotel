package br.com.cvc.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestHotelDTO {
	
    private Integer cityId;
    private Integer hotelId;
    private String checkInDate;
    private String checkOutDate;
    private Integer numberOfAdults;
    private Integer numberOfChildren;
        
}
