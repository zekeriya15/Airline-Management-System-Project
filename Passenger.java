import java.util.ArrayList;
import java.util.Scanner;

public  class Passenger {
	private static final String CODE  = "PS";
	
	private String passengerId;
	private String firstName;
	private String lastName;
	private String passportNo;
	private String phone;
	private ArrayList<Luggage> luggages;
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
	
	
	
	public void addLuggageToList(Luggage l) {
		this.luggages.add(l);
	};

	
//	public void books(int bookingId, Flight flight) {
//		Booking b = new Booking(bookingId, this, flight);
//		flight.addBooking(b);
//		
//		this.bookings.add(b);
//		
//		System.out.println(firstName + " " + lastName+ "Succesfully booked flight " + flight.getFlightNo() + " " + 
//					flight.getOrigin() + " - " + flight.getDestination());
//		
//		return;
//	}
	
	public void books(String flightNo, Scanner s) {
		
		for (Flight f : Airline.getFlights()) {
			if (f.getFlightNo().equals(flightNo)) {
		
				Booking b = null;
				String passengerClass = "";
				
				do {
					System.out.print("Choose class:\n1. First Class\n2. Business Class\n3. Economy Class\nOption: ");
					
					int bookingClass = s.nextInt();
					
					switch (bookingClass) {
					case 1:
						b = new First(this, f);
						passengerClass = "First";
						break;
					case 2:
						b = new Business(this, f);
						passengerClass = "Business";
						break;
					case 3:
						b = new Economy(this, f);
						passengerClass = "Economy";
						break;
					default:
						System.out.println("Invalid booking class");
						b = null;
						break;
					}
					
				} while (b == null);
				
				
				this.bookings.add(b); 
				f.addBooking(b);
				
				
				System.out.println(firstName + " " + lastName + " has succesfully booked flight " + f.getFlightNo() + ", " + 
						f.getOrigin() + " - " + f.getDestination() + " with " + passengerClass);
				
				return;
			}
		}
		// if the loop has serached thru the end of list it means that the if statement didnt get touched and the fligh actually desnt exist
		System.out.println("The flight: " + flightNo + " doesnt exist");
	}
		
	public void checkIn(String bookingId, Scanner s) {
	    for (Booking b : this.bookings) {
	        if (b.getBookingId().equalsIgnoreCase(bookingId)) {
	            
	            System.out.print("Do you want to add luggage? (Y/N): ");
	            char option = s.next().toUpperCase().charAt(0);
	            
	            while (option == 'Y') {
	                System.out.print("Enter luggage type (ex. suitcase, carry-on): ");
	                s.nextLine(); // Clear the buffer
	                String type = s.nextLine();
	                
	                double weight = 0;
	                boolean validWeight = false;
	                
	                while (!validWeight) {
	                    System.out.print("Enter weight (in kg): ");
	                    
	                    if (s.hasNextDouble()) {
	                        weight = s.nextDouble();
	                        s.nextLine(); // Clear the buffer
	                        if (weight > 0) {
	                            validWeight = true;
	                        } else {
	                            System.out.println("Weight must be a positive value.");
	                        }
	                    } else {
	                        System.out.println("Invalid weight input. Please enter a numeric value.");
	                        s.nextLine(); // Clear the invalid input
	                    }
	                }
	                
	                b.addLuggage(new Luggage(type, weight, this));
	                System.out.println("Luggage added successfully.");
	                
	                System.out.print("Continue adding luggage? (Y/N): ");
	                option = s.next().toUpperCase().charAt(0); // Normalize input to uppercase
	            }
	            
	            b.checkIn();
	            System.out.println("Checked in successfully.");
	            return; // Exit the method after checking in
	        }
	    }
	    
	    System.out.println("Booking ID " + bookingId + " not found.");
	}

	
//	public void checkIn(String flightNo) {
//		for (Booking b : bookings) {
//			if (b.getFlight().getFlightNo().equalsIgnoreCase(flightNo)) {
//				b.checkIn();
//				
//				System.out.println(firstName + " " + lastName + " has checked in for flight " + b.getFlight().getFlightNo() + ", " + b.getFlight().getOrigin() + " - " + b.getFlight().getDestination());
//				return; // exit entire method
//			}
//		}
//		
//		// if the loop has serached thru the end of list it means that the if statement didnt get touched and the fligh actually desnt exist
//		System.out.println("No booking found for flight " + flightNo);
//	}
	
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
	
	public void printBookings() {
		System.out.println("\n--------------------");
		System.out.println("Booking Id\tFlight No\tRoute\t\tPassenger Class\t\tLuggages");
		for (Booking b: bookings) {
			b.print();
		}
		System.out.println("\n--------------------");
	}
	

	public void print() {
		System.out.println(passengerId + "\t\t" + firstName + "\t\t" + lastName + "\t\t" + passportNo + "\t\t" +
						phone + "\t" + bookings.size());
		
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
