package br.com.cvc.hotel.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class HotelDTO implements Serializable{
	private Integer id;
	private String city;
	private String name;
	private List<RoomDTO> rooms;	

}
