package br.com.cvc.hotel.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseHotelDTO {

	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("cityCode")
	private int cityCode;
	
	@JsonProperty("cityName")
	private String cityName;
	
	@JsonProperty("rooms")
	private List<ResponseRoomDTO> rooms;
}
