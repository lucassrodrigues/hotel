package br.com.cvc.hotel.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RoomDTO implements Serializable{
		
	private Integer id;
	private CategoryDTO category;
	private BigDecimal totalPrice; 
	private PriceDTO priceDetail;
	
	
	
	

}
