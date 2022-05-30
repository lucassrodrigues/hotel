package br.com.cvc.hotel.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class PriceDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private BigDecimal adult;
	private BigDecimal child;	
}
