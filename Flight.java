import java.time.LocalDateTime;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Flight implements Comparable<Flight> {
	private static final String CODE = "FL";
	
	private String flightId;
	private String flightNo;
	private Aircraft plane;
	private String origin;
	private String destination;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private int seatAvailable;
	private String status;
	private ArrayList<Booking> bookings;
	
	public Flight(String flightNo, Aircraft plane, String origin, String destination) {
		this.flightId = CODE + generateId();
		this.flightNo = flightNo;
		this.plane = plane;
		this.origin = origin;
		this.destination = destination;
		this.seatAvailable = plane.getCapacity();
		this.status = "On Time";
		this.bookings = new ArrayList<>();
		
		Airline.addFlight(this);
	}
	
	private static int generateId() {
		int id = 0;
		
		if (Airline.getFlights().size() != 0) {
			Flight lastIndexValue = Airline.getFlights().get(Airline.getFlights().size() - 1);
			String lastFlightId = lastIndexValue.getFlightId();
			String numValue = lastFlightId.substring(CODE.length(), lastFlightId.length());
			int numValueParsed = Integer.parseInt(numValue);
			
			id = ++numValueParsed;
		}
		
		return id;
	}
	
	
//	getters
	public String getFlightId() {
		return flightId;
	}
	
	public String getFlightNo() {
		return flightNo;
	}
	
	public Aircraft getAircraft() {
		return plane;
	}
	
	public String getOrigin() {
		return origin;
	}
	
	public String getDestination() {
		return destination;
	}
	
	public LocalDateTime getdepartureTime() {
		return departureTime;
	}
	
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	
	public int getSeatAvailable() {
		return seatAvailable;
	}
	
	public String getStatus() {
		return status;
	}
	
	public ArrayList<Booking> getBookings() {
		return bookings;
	}
	
	
//	setters
	public void setFlightId(String id) {
		this.flightId = id;
	}
	
	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}
	
	public void setAircraft(Aircraft plane) {
		this.plane = plane;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	public void setDepartureTime(int year, int month, int day, int hour, int minute) {
		this.departureTime = LocalDateTime.of(year, month, day, hour, minute);
	}
	
	public void setArrivalTime(int year, int month, int day, int hour, int minute) {
		this.arrivalTime = LocalDateTime.of(year, month, day, hour, minute);
	}
	
	public void setDeapartureTime(String departureTime) {
		this.departureTime = parseDateTime(departureTime);
	}
	
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = parseDateTime(arrivalTime);
	}
	
	private static LocalDateTime parseDateTime(String dateTimeInput) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		try {
			return LocalDateTime.parse(dateTimeInput, formatter);
		} catch (DateTimeParseException e) {
			System.out.println("Invalid date-time format. Please use 'yyyy-MM-dd HH:mm'");
			throw e;
		}
	}
	
	
	public void setSeatAvailable(Aircraft plane) {
		this.seatAvailable = plane.getCapacity();
	}
	
	public void setSeatAvailable(int seats) {
		this.seatAvailable = seats;
	}
	
	public void setBooking(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
	
	
//	methods
	public void addBooking(Booking b) {
		if (this.seatAvailable > 0) {
			this.bookings.add(b);
			this.seatAvailable--;
		} else {
			System.out.println("There's no seat left");
		}
	}
	
	public ArrayList<Passenger> getCheckedInPassengers() {
		ArrayList<Passenger> checkedInPassengers = new ArrayList<>();
		
		for (Booking b : this.bookings) {
			if (b.isCheckedIn()) {
				checkedInPassengers.add(b.getPassenger());
			}
		}
		
		return checkedInPassengers;
	}
	
	public void printCheckedInPassengers() {
		ArrayList<Passenger> checkedInPassengers = this.getCheckedInPassengers();
		
		System.out.println("Total checked in passengers: " + checkedInPassengers.size());
		
		for (Passenger p : checkedInPassengers) {
			System.out.println("=================");
//			p.print();
			System.out.println("=================");
		}
	}
	
	public void cancelFlight() {
		this.status = "Canceled";
		
		System.out.println("Flight no: " + flightNo + ", Route " + origin + "-" + destination + " has been canceled");
	}
	
	public void delayFlight() {
		this.status = "Delayed";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy, HH:mm");
		
		System.out.println("\nFlight no " + flightNo + " with route " + origin + " - " + destination + " scheduled to fly at " +
				departureTime.format(formatter) + " is delayed");
	}
	
	public void print() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy, HH:mm");
		
		System.out.println(flightId + "\t\t" + flightNo + "\t\t" + plane.getAircraftId() + " " + plane.getModel() + "\t" +
				origin + " - " + destination + "\t" + departureTime.format(formatter) +"\t" + arrivalTime.format(formatter) + "\t" +
				status + "\t\t" + bookings.size() + "/" + plane.getCapacity());
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, dd MMM yyyy, HH:mm");
		
		return "id: " + flightId + 
				"\nAirline: " + Airline.getName() +
				"\nFlight No: " + flightNo +
				"\nAircraft: " + plane.getAircraftId() + ", " + plane.getModel() +
				"\nRoute: " + origin + " - " + destination +
				"\nDeparture Time: " + departureTime.format(formatter) +
				"\nArrival Time: " + arrivalTime.format(formatter) +
				"\nSeat Available: " + seatAvailable +
				"\nStatus: " + status;
	}
	
	@Override
	public int compareTo(Flight other) {
		return this.departureTime.compareTo(other.departureTime);
	}
	
	
}
