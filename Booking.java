
public class Booking {
	private int bookingId;
	private Passenger passenger;
	private Flight flight;
	private boolean isCheckedIn;
	
	public Booking(int bookingId, Passenger p, Flight f) {
		this.bookingId = bookingId;
		this.passenger = p;
		this.flight = f;
		this.isCheckedIn = false;
	}
	
//	getters
	public int getBookingId() {
		return bookingId;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}
	
	public Flight getFlight() {
		return flight;
	}
	
	public boolean isCheckedIn() {
		return isCheckedIn;
	}
	
//	setters
	public void setBookingId(int id) {
		this.bookingId = id;
	}
	
	public void setPassenger(Passenger p) {
		this.passenger = p;
	}
	
	public void setFlight(Flight f) {
		this.flight = f;
	}
	
	public void setIsCheckedIn(boolean b) {
		this.isCheckedIn = b;
	}
	
	
	
//	methods
	public void checkIn() {
		this.isCheckedIn = true;
	}
	
	@Override
	public String toString() {
		return "Booking id: " + bookingId + 
				"\nFlight No: " + flight.getFlightNo() + ", " + flight.getOrigin() + " - " + flight.getDestination() +
				"\nChecked In: " + isCheckedIn;
	}
	

}
