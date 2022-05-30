package br.com.cvc.hotel.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cvc.hotel.client.HotelClient;
import br.com.cvc.hotel.dto.CategoryDTO;
import br.com.cvc.hotel.dto.HotelDTO;
import br.com.cvc.hotel.dto.PriceDTO;
import br.com.cvc.hotel.dto.RequestHotelDTO;
import br.com.cvc.hotel.dto.ResponseHotelDTO;
import br.com.cvc.hotel.dto.ResponseRoomDTO;
import br.com.cvc.hotel.dto.RoomDTO;
import br.com.cvc.hotel.util.Utils;

@Service
public class HotelService {
	
	@Autowired
	private HotelClient hotelClient;

	
	public List<HotelDTO> getDailyHotelPrice(RequestHotelDTO request) {
		
		var dias = Utils.getDaysOfBooking(request.getCheckInDate(), request.getCheckOutDate());
		
		if(request.getHotelId() != null) {
			var hotel = this.findHotelById(request.getHotelId());
			return this.transform(hotel, dias, request);
		}
		var hoteis = this.findHotelsByCityId(request.getCityId());
		return this.transform(hoteis, dias, request);
		
	}
	
	private List<HotelDTO> transform(List<ResponseHotelDTO> hoteis, Integer dias, RequestHotelDTO request){
		List<HotelDTO> response = new ArrayList<>();
		response.addAll(
		hoteis.parallelStream().map(h ->
			HotelDTO.builder()
				.id(h.getId())
				.city(h.getCityName())
				.name(h.getName())
				.rooms(h.getRooms().parallelStream().map(r ->
							RoomDTO.builder()
								.id(r.getRoomID())
								.category(CategoryDTO.builder().name(r.getCategoryName()).build())
								.totalPrice(this.calculaPreco(dias, r, request.getNumberOfAdults(), request.getNumberOfChildren()))
								.priceDetail(PriceDTO.builder()
												.adult(new BigDecimal(r.getPrice().getAdult()))
												.child(new BigDecimal(r.getPrice().getChild()))
											.build())
							.build()).toList())		
			.build()).toList());
		
		return response;
	}
	
	private BigDecimal calculaPreco(Integer dias, ResponseRoomDTO room, Integer adult, Integer child) {
		
		var valorAdultos = new BigDecimal(room.getPrice().getAdult()).multiply(new BigDecimal(adult)).multiply(new BigDecimal(dias));
		var valorCrianca = new BigDecimal(room.getPrice().getChild()).multiply(new BigDecimal(child)).multiply(new BigDecimal(dias));
		
		var soma = valorAdultos.add(valorCrianca);
		
		//({valorTotalAdulto}+{valorTotalCriança}/0.7) Ex: (500/0.7);
		//Somar tudo e você terá o totalPrice

		return soma.divide(new BigDecimal("0.7"), 2, RoundingMode.CEILING);
	}
 	
	public List<ResponseHotelDTO> findHotelsByCityId(Integer idCidade){
		return hotelClient.findHotelsByCityId(idCidade);
	}
	
	public List<ResponseHotelDTO> findHotelById(Integer idHotel){
		return hotelClient.findHotelById(idHotel);
	}
	
}
