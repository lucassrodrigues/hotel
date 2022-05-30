package br.com.cvc.hotel.client;

import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.cvc.hotel.dto.ResponseHotelDTO;

@Component
public class HotelClient {
	
	private static final String HOTEL_URL = "https://cvcbackendhotel.herokuapp.com/hotels";
	
	public List<ResponseHotelDTO> findHotelsByCityId(Integer idCidade) {
		ObjectMapper mapper = new ObjectMapper();
		ResponseHotelDTO[] listaHoteis = null;
		
		try {
			 listaHoteis = mapper.readValue(new URL(this.HOTEL_URL + "/avail/" + idCidade), ResponseHotelDTO[].class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Arrays.asList(listaHoteis);
	}
	
	public List<ResponseHotelDTO> findHotelById(Integer idHotel) {
		ObjectMapper mapper = new ObjectMapper();
		ResponseHotelDTO[] listaHoteis = null;
		
		try {
			 listaHoteis = mapper.readValue(new URL(this.HOTEL_URL +"/"+ idHotel), ResponseHotelDTO[].class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return Arrays.asList(listaHoteis);
	}
	
	
}
