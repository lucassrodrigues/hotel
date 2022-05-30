package br.com.cvc.hotel.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Utils {

	// Calculo de dias de reserva
	public static int getDaysOfBooking(String checkin, String checkout) {

		Period periodInDays = Period.between(
						LocalDate.parse(checkin, DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
						LocalDate.parse(checkout, DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		return periodInDays.getDays();
	}

	public Double getTotalPriceBooking(int days, int childs, int adults) {
		Double totalPrice;

		totalPrice = (double) ((childs * days) + (childs * days));
		return totalPrice;
	}

	public Double addComissionBooking(Double price) {
		return price + (price / 0.7);
	}

}
