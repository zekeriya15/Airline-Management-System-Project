import java.util.ArrayList;

public abstract class Passenger {
	private static final String CODE  = "PS";
	
	protected String passengerId;
	protected String firstName;
	protected String lastName;
	protected String passportNo;
	protected String phone;
	protected ArrayList<Luggage> luggages;
	private ArrayList<Booking> bookings;
	
	public Passenger(String firstName, String lastName, String passportNo, String phone) {
		this.passengerId = CODE + generateId();
		this.firstName = firstName;
		this.lastName = lastName;
		this.passportNo = passportNo;
		this.phone = phone;
		this.luggages = new ArrayList<>();
		this.bookings = new ArrayList<>();
		
		Airline.addPassenger(this);
	}
	
	private static int generateId() {
		int id = 0;
		
		if (Airline.getPassengers().size() != 0) {
			Passenger lastIndexValue = Airline.getPassengers().get(Airline.getPassengers().size() - 1);
			String lastPassengerId = lastIndexValue.getPassengerId();
			String numValue = lastPassengerId.substring(CODE.length(), lastPassengerId.length());
			int numValueParsed = Integer.parseInt(numValue);
			
			id = ++numValueParsed;
		}
		
		return id;
	}
	
	
//	getters
	public String getPassengerId() {
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
	
	
	
//	setters
	public void setPassengerId(String id) {
		this.passengerId = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setPassportNo(String passportNo) {
		this.passportNo = passportNo;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void setLuggages(ArrayList<Luggage> luggages) {
		this.luggages = luggages;
	}
	
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}
	
	
	
//	methods
//	public void addLuggage(Luggage l) {
//		this.luggages.add(l);
//	}
	
	public void printLuggages() {
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
	
	
	public abstract void addLuggage(Luggage l);

	
	public void books(int bookingId, Flight flight) {
		Booking b = new Booking(bookingId, this, flight);
		flight.addBooking(b);
		
		this.bookings.add(b);
		
		System.out.println(firstName + " " + lastName+ "Succesfully booked flight " + flight.getFlightNo() + " " + 
					flight.getOrigin() + " - " + flight.getDestination());
		
		return;
	}
	
	public void books(int bookingId, String flightNo) {
		
		for (Flight f : Airline.getFlights()) {
			if (f.getFlightNo().equals(flightNo)) {
				Booking b = new Booking(bookingId, this, f);
				f.addBooking(b);
				
				this.bookings.add(b); 
				
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
	

	public void print() {
		String passengerClass = "";
		if (this instanceof Economy) {
			passengerClass = "Economy Class";
		} else if (this instanceof Business) {
			passengerClass = "Business Class";
		} else if (this instanceof First) {
			passengerClass = "First Class";
		}
		
		System.out.println(passengerId + "\t\t" + firstName + "\t\t" + lastName + "\t\t" + passportNo + "\t\t" +
						phone + "\t" + passengerClass + "\t\t" + luggages.size());
		
	}
	
	
//	methods
//	public void printt() {
//		String pasenggerClass = "";
//		if (this instanceof Economy) {
//			pasenggerClass = "Economy Class";
//		} else if (this instanceof Business) {
//			pasenggerClass = "Business Class";
//		} else if (this instanceof First) {
//			pasenggerClass = "First Class";
//		}
//		
//		
//		System.out.println("id: " + passengerId +
//				"\nFirst Name: " + firstName + 
//				"\nLast Name: " + lastName +
//				"\nPassenger Class: " + pasenggerClass +
//				"\nPassport Number: " + passportNo +
//				"\nPhone Number: " + phone +
//				"\nNumber of Luggages: " + this.getNumOfLuggages());
//		this.printLuggages();
//		
//		System.out.println("Number of Bookings: " + this.getNumOfBookings());
//		this.printBookings();
//	}
}
