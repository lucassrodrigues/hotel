package br.com.cvc.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cvc.hotel.dto.HotelDTO;
import br.com.cvc.hotel.dto.RequestHotelDTO;
import br.com.cvc.hotel.dto.ResponseHotelDTO;
import br.com.cvc.hotel.service.HotelService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	
	@ApiOperation(value = "API CVC - Calcula o valor da diaria dos hoteis da cidade")
	@RequestMapping(value = "/getDailyHotelPrice", method = RequestMethod.GET)
	public List<HotelDTO> getDailyHotelPrice(@Validated @RequestBody final RequestHotelDTO request) {
		var response = this.hotelService.getDailyHotelPrice(request);
		
		return response;
	}
	
	
	/**
	 * Método que integra a API do fornecedor CVC
	 */
	@ApiOperation(value = "API FORNECEDOR - Lista os hoteis de uma cidade")
	@RequestMapping(value = "/findHotelsByCityId", method = RequestMethod.GET)
	public List<ResponseHotelDTO> findHotelsByCityId(@RequestParam Integer idCidade) {
		var response = this.hotelService.findHotelsByCityId(idCidade);

		return response;
	}

	/**
	 * Método que integra a API do fornecedor CVC
	 */
	@ApiOperation(value = "API FORNECEDOR - Lista um hotel específico")
	@RequestMapping(value = "/findHotelById", method = RequestMethod.GET)
	public List<ResponseHotelDTO> findHotelById(@RequestParam Integer idHotel) {
		var response = this.hotelService.findHotelById(idHotel);
		
		return response;
	}
	
}
