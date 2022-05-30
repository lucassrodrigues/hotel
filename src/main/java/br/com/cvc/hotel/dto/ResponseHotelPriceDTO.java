package br.com.cvc.hotel.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@AllArgsConstructor
@ApiModel(value = "Hotel Response", description = "Informations of an Hotel response")
public class ResponseHotelPriceDTO implements Serializable{
	
	private List<ResponseHotelDTO> hotel;
	
	public ResponseHotelPriceDTO() {
	}

}
