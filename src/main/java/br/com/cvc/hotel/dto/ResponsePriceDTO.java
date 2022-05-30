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
public class ResponsePriceDTO {
	
	@JsonProperty("adult")
	private String adult;
	
	@JsonProperty("child")
	private String child;
}
