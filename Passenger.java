import java.util.ArrayList;

public abstract class Passenger {
	private int passengerId;
	private String firstName;
	private String lastName;
	private String passportNo;
	private String phone;
	protected ArrayList<Luggage> luggages;
	private ArrayList<Booking> bookings;
	
	public Passenger(int passengerId, String firstName, String lastName, String passportNo, String phone) {
		this.passengerId = passengerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passportNo = passportNo;
		this.phone = phone;
		this.luggages = new ArrayList<>();
		this.bookings = new ArrayList<>();
		
		Airline.addPassenger(this);
	}
	
	
//	getters
	public int getPassengerId() {
		return passengerId;
	}
	
	public String getfirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPassportNo() {
		return passportNo;
	}
	
	public String getPhone() {
		return phone;
	}
	
	private void printLuggages() {
		System.out.println("=================");
		for (Luggage l : luggages) {
			System.out.println(l);
		}
		System.out.println("=================");
	}
	
	private void printBookings() {
		System.out.println("=================");
		for (Booking b: bookings) {
			System.out.println(b);
		}
		System.out.println("=================");
	}
	
	public ArrayList<Luggage> getLuggages() {
		return luggages;
	}
	
	public ArrayList<Booking> getBookings() {
		return bookings;
	}
	
	public int getNumOfLuggages() {
		return luggages.size();
	}
	
	public int getNumOfBookings() {
		return bookings.size();
	}
	
	
	
	
//	methods
//	public void addLuggage(Luggage l) {
//		this.luggages.add(l);
//	}
	
	public abstract void addLuggage(Luggage l);

	
	public void books(int bookingId, Flight flight) {
		Booking b = new Booking(bookingId, this, flight);
		this.bookings.add(b);
		
		flight.addBooking(b);
		
		System.out.println(firstName + " " + lastName+ "Succesfully booked flight " + flight.getFlightNo() + " " + 
					flight.getOrigin() + " - " + flight.getDestination());
	}
	
	public void books(int bookingId, String flightNo) {
		
		for (Flight f : Airline.getFlights()) {
			if (f.getFlightNo().equals(flightNo)) {
				Booking b = new Booking(bookingId, this, f);
				this.bookings.add(b);
				
				f.addBooking(b);
				
				System.out.println(firstName + " " + lastName + " has succesfully booked flight " + f.getFlightNo() + ", " + 
						f.getOrigin() + " - " + f.getDestination());
				
				return;
			}
		}
		// if the loop has serached thru the end of list it means that the if statement didnt get touched and the fligh actually desnt exist
		System.out.println("The flight: " + flightNo + " doesnt exist");
	}
		
	
	
	public void checkIn(String flightNo) {
		for (Booking b : bookings) {
			if (b.getFlight().getFlightNo().equalsIgnoreCase(flightNo)) {
				b.checkIn();
				
				System.out.println(firstName + " " + lastName + " has checked in for flight " + b.getFlight().getFlightNo() + ", " + b.getFlight().getOrigin() + " - " + b.getFlight().getDestination());
				return; // exit entire method
			}
		}
		
		// if the loop has serached thru the end of list it means that the if statement didnt get touched and the fligh actually desnt exist
		System.out.println("No booking found for flight " + flightNo);
	}
	
	public void checkIn(Flight flight) {
		for (Booking b : bookings) {
			if (b.getFlight().equals(flight)) {
				b.checkIn();
				
				System.out.println(firstName + " " + lastName + " has checked in for flight " + flight.getFlightNo() + ", " + flight.getOrigin() + " - " + flight.getDestination());
				
				return; // exit entire method
			}
		}
		
		// if the loop has serached thru the end of list it means that the if statement didnt get touched and the fligh actually desnt exist
		System.out.println("No booking found for flight " + flight.getFlightNo() );
	}
	
//	public void checkIn(Flight flight) {
//		boolean found = false;
//		
//		for (Booking b : bookings) {
//			if (b.getFlight().equals(flight)) {
//				b.checkIn();
//				
//				System.out.println(firstName + " " + lastName + " has checked in for flight " + flight.getFlightNo());
//				found = true;
//				break; // exit loop
//			}
//		}
//		
//		if (!found) {
//			System.out.println("No booking found for flight " + flight.getFlightNo() );
//
//		}
//	}
	
	
	
//	methods
	public void print() {
		String pasenggerClass = "";
		if (this instanceof Economy) {
			pasenggerClass = "Economy Class";
		} else if (this instanceof Business) {
			pasenggerClass = "Business Class";
		} else if (this instanceof First) {
			pasenggerClass = "First Class";
		}
		
		
		System.out.println("id: " + passengerId +
				"\nFirst Name: " + firstName + 
				"\nLast Name: " + lastName +
				"\nPassenger Class: " + pasenggerClass +
				"\nPassport Number: " + passportNo +
				"\nPhone Number: " + phone +
				"\nNumber of Luggages: " + this.getNumOfLuggages());
		this.printLuggages();
		
		System.out.println("Number of Bookings: " + this.getNumOfBookings());
		this.printBookings();
	}
}
