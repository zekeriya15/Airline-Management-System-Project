import java.util.ArrayList;
import java.util.Collections;

public class Airline {
	private static final String name = "Qatar Airways";
	private static ArrayList<Aircraft> planes = new ArrayList<>();
	private static ArrayList<Flight> flights = new ArrayList<>();
	private static ArrayList<Passenger> passengers = new ArrayList<>();
	

//	getters
	public static String getName() {
		return name;
	}
	
	public static void addAircraft(Aircraft plane) {
		planes.add(plane);
	}
	
	public static void addFlight(Flight f) {
		flights.add(f);
	}
	
	public static void addPassenger(Passenger p) {
		passengers.add(p);
	}
	
	
//	getters
	public static ArrayList<Aircraft> getAircrafts() {
		return planes;
	}
	
	public static ArrayList<Flight> getFlights() {
		Collections.sort(flights);
		return flights;
	}
	
	public static ArrayList<Passenger> getPassengers() {
		return passengers;
	}
	
	
	
	private static ArrayList<Flight> getFlightsByRoute(String origin, String destination) {
		ArrayList<Flight> result = new ArrayList<>();
		for (Flight f : flights) {
			if (f.getOrigin().equalsIgnoreCase(origin) && f.getDestination().equalsIgnoreCase(destination)) {
				result.add(f);
			}
		}

		return result;
	}
	
	public static void findFlightsByRoute(String origin, String destination) {
		ArrayList<Flight> flights = getFlightsByRoute(origin, destination);
		
		System.out.println("=================");
		for (Flight f : flights) {
			System.out.println(f);
		}
		System.out.println("=================");
	}
	
	public static void printAllFlights() {
		ArrayList<Flight> flights = getFlights();
		
		System.out.println("\n-----------------");
		System.out.println("Flight Id\tFlight No\tAircraft\tRoute\t\tDeparture Time\t\t\tArrival Time\t\t\tStatus\t\tSeats Taken");
		for (Flight f : flights) {
			f.print();
		}
		System.out.println("\n-----------------");
	}
	
	public static void printAllAircrafts() {
		ArrayList<Aircraft> planes = getAircrafts();
		
		System.out.println("\n-----------------");
		System.out.println("Aircraft Id\tModel\t\tCapacity");
		for (Aircraft plane : planes) {
			plane.print();
		}
		System.out.println("\n-----------------");
	}
	
	public static void printAllPassengers() {
		ArrayList<Passenger> passengers = getPassengers();
		
		System.out.println("\n-----------------");
		System.out.println("Passenger Id\tFirst Name\tLast Name\tPassport No\tPhone\t\tBookings");
		for (Passenger p : passengers) {
			p.print();
		}
		System.out.println("\n-----------------");
	}

}
