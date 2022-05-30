package br.com.cvc.hotel.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRoomDTO {
	
	@JsonProperty("roomID")
	private Integer roomID;
	
	@JsonProperty("categoryName")
	private String categoryName;
	
	@JsonProperty("price")
	private ResponsePriceDTO price;
	
}
