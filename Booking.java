import java.util.ArrayList;

public abstract class Booking {
	private static final String CODE = "BK";
	
	protected String bookingId;
	protected Passenger passenger;
	protected Flight flight;
	protected boolean isCheckedIn;
	protected ArrayList<Luggage> luggages;
	
	public Booking(Passenger p, Flight f) {
		this.bookingId = generateId(p);
		this.passenger = p;
		this.flight = f;
		this.isCheckedIn = false;
		luggages = new ArrayList<>();
	}
	
	private static String generateId(Passenger p) {
		int id = 0;
		
		if (p.getBookings().size() != 0) {
			Booking lastIndexValue = p.getBookings().get(p.getBookings().size() - 1);
			String lastBookingId = lastIndexValue.getBookingId();
			
			String numValue = lastBookingId.substring(lastBookingId.lastIndexOf(CODE) + CODE.length(), lastBookingId.length());
			int numValueParsed = Integer.parseInt(numValue);
			
			id = ++numValueParsed;
		}
		
		return p.getPassengerId() + CODE + id;
	}
	
//	getters
	public String getBookingId() {
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
	
	public ArrayList<Luggage> getLuggages() {
		return luggages;
	}
	
//	setters
	public void setBookingId(String id) {
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
	
	public void setLuggages(ArrayList<Luggage> l) {
		this.luggages = l;
	}
	
	
	
//	methods
	public void checkIn() {
		this.isCheckedIn = true;
	}
	
	public abstract void addLuggage(Luggage l);
	
	public void print() {
		String passengerClass = "";
		if (this instanceof Economy) {
			passengerClass = "Economy";
		} else if (this instanceof Business) {
			passengerClass = "Business";
		} else if (this instanceof First) {
			passengerClass = "First";
		}
		
		System.out.println(bookingId + "\t\t" + flight.getFlightNo() + "\t\t" + flight.getOrigin() + " - " + flight.getDestination() +
				"\t" + passengerClass + "\t\t\t" + luggages.size() + "\t\t" + isCheckedIn);
	}
	
	@Override
	public String toString() {
		return "Booking id: " + bookingId + 
				"\nFlight No: " + flight.getFlightNo() + ", " + flight.getOrigin() + " - " + flight.getDestination() +
				"\nChecked In: " + isCheckedIn;
	}
	

}
