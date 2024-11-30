import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Flight implements Comparable<Flight> {
	private int flightId;
	private String flightNo;
	private Aircraft plane;
	private String origin;
	private String destination;
	private LocalDateTime departureTime;
	private LocalDateTime arrivalTime;
	private int seatAvailable;
	private String status;
	private ArrayList<Booking> booking;
	
	public Flight(int flightId, String flightNo, Aircraft plane, String origin, String destination) {
		this.flightId = flightId;
		this.flightNo = flightNo;
		this.plane = plane;
		this.origin = origin;
		this.destination = destination;
		this.seatAvailable = plane.getCapacity();
		this.status = "On Time";
		this.booking = new ArrayList<>();
		
		Airline.addFlight(this);
	}
	
//	getters
	public int getFlightId() {
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
	
	
	
//	setters
	public void setDepartureTime(int year, int month, int day, int hour, int minute) {
		this.departureTime = LocalDateTime.of(year, month, day, hour, minute);
	}
	
	public void setArrivalTime(int year, int month, int day, int hour, int minute) {
		this.arrivalTime = LocalDateTime.of(year, month, day, hour, minute);
	}
	
	public void cancelFlight() {
		this.status = "Canceled";
		
		System.out.println("Flight no: " + flightNo + ", Route " + origin + "-" + destination + " has been canceled");
	}
	
//	public void setSeatAvailable(Aircraft plane) {
//		this.seatAvailable = plane.getCapacity();
//	}
	
	
	
//	methods
	public void addBooking(Booking b) {
		if (this.seatAvailable > 0) {
			this.booking.add(b);
			this.seatAvailable--;
		} else {
			System.out.println("There's no seat left");
		}
	}
	
	public ArrayList<Passenger> getCheckedInPassengers() {
		ArrayList<Passenger> checkedInPassengers = new ArrayList<>();
		
		for (Booking b : this.booking) {
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
			p.print();
			System.out.println("=================");
		}
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
