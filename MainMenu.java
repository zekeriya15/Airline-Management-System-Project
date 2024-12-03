import java.util.Scanner;


public class MainMenu {
	
	static Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		boolean running = true;
		
		while(running) {
			System.out.println("\n----- Qatar Airways Flight Management System -----\n");
			System.out.println("1. Create Aircraft");
			System.out.println("2. Create Flight");
			System.out.println("3. Delay Flight");
			System.out.println("4. Cancel Flight");
			System.out.println("5. Add Passenger");
			System.out.println("6. Add luggage to passenger");
			System.out.println("7. Book flight for passenger");
			System.out.println("8. Check in for passenger");
			System.out.println("9. Get list of passenger's luggages");
			System.out.println("10. Get list of checked in passenger");
			System.out.println("11. Get list of passengers");
			System.out.println("12. Get list of all available flights");
			System.out.println("13. Get all flights by route");
			System.out.println("14. Get list of all aircrafts");
			System.out.println("0. Quit");
			
			System.out.print("\nChoose option: ");
			int option = s.nextInt();	s.nextLine();
			
			switch (option) {
			case 1: 
				createAircraft();
				break;
			case 2:
				createFlight();
				break;
			case 3:
				delayFlight();
				break;
			case 4:
				cancelFlight();
				break;
			
				
			case 12:
				Airline.printAllFlights();
				break;
				
			case 14:
				Airline.printAllAircrafts();
				break;
				
			case 0:
				running = false;
				break;
				
			default:
				System.out.println("Input is incorrect");
			}
			
			
		}
		
		
	}
	
	
	private static void createAircraft() {
		System.out.print("Enter aircraft's model: ");
		String model = s.nextLine();
		System.out.print("Enter aircraft's seat capacity: ");
		int capacity = s.nextInt();
		
		Aircraft plane = new Aircraft(model, capacity);
		
		System.out.println("\nAircraft succesfully added\n");
		
	}
	
	private static void createFlight() {
		
		System.out.print("Enter Aircraft Id: (-1 to show all aircrafts): ");
		String aircraftId = s.nextLine();
		
		if (aircraftId.equals("-1")) {
			Airline.printAllAircrafts();
			
			System.out.print("Enter Aircraft Id: ");
			aircraftId = s.nextLine();
		}
		
		System.out.print("Enter flight number: ");
		String flightNo = s.nextLine();
		
		System.out.print("Enter origin: ");
		String origin = s.nextLine();
		
		System.out.print("Enter destination: ");
		String destination = s.nextLine();
		
		System.out.print("Enter departure time (yyyy-MM-dd HH:mm): ");
		String departureTime = s.nextLine();
		
		System.out.print("Enter arrival time (yyyy-MM-dd HH:mm): ");
		String arrivalTime = s.nextLine();
		
		
		for (Aircraft plane : Airline.getAircrafts()) {
			if (plane.getAircraftId().equalsIgnoreCase(aircraftId)) {
				
				Flight f = new Flight(flightNo, plane, origin, destination);
				f.setDeapartureTime(departureTime);
				f.setArrivalTime(arrivalTime);
				
				System.out.println("\nFlight succesfully added\n");
				
				return;
			}
		}
		
		System.out.println("Aircraft id " + aircraftId + " isnt found");
	}
	
	private static void delayFlight() {
		System.out.print("Enter  Flight Number (-1 to show all flights): ");
		String flightNo = s.nextLine();
		
		if (flightNo.equals("-1")) {
			Airline.printAllFlights();
			
			System.out.print("Enter Flight Number: ");
			flightNo = s.nextLine();
		}
		
		for (Flight f : Airline.getFlights()) {
			if (f.getFlightNo().equals(flightNo)) {
				f.delayFlight();
				return;
			}
		}
		
		System.out.println("Flight " + flightNo + " isnt found");
	}
	
	private static void cancelFlight() {
		System.out.print("Enter Flight Number (-1 to show all flight):");
		String flightNo = s.nextLine();
		
		if (flightNo.equals("-1")) {
			Airline.printAllFlights();
			
			System.out.print("Enter Flight Number: ");
			flightNo = s.nextLine();
		}
		
		for (Flight f : Airline.getFlights()) {
			if (f.getFlightNo().equals(flightNo)) {
				f.cancelFlight();
				return;
			}
		}
		
		System.out.println("Flight " + flightNo + " isnt found");
	}

}
