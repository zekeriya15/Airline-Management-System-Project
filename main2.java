import java.util.Scanner;

public class main2 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
//		System.out.println(Airline.getAircrafts().size());
//		
//		Airline.printAllFlights();
		
//		Airline.printAllAircrafts();
		
		Aircraft plane = new Aircraft("Boieng 777", 500);
		Aircraft plane2 = new Aircraft("Boieng 787", 600);
		
		Flight f1 = new Flight("AQ21", plane, "dubai", "doha");
		f1.setDeapartureTime("2024-10-10 10:00");
		f1.setArrivalTime("2024-10-10 11:00");
		
		Flight f2 = new Flight("AQ21", plane2, "doha", "berlin");
		f2.setDeapartureTime("2024-12-10 10:00");
		f2.setArrivalTime("2024-12-10 11:00");
		
		Airline.printAllAircrafts();
		Airline.printAllFlights();
		
		f2.delayFlight();
		
		Passenger p1 = new Passenger("Me", "Myself", "CA23098", "01998763");
		Passenger p2 = new Passenger("Yakup", "Yakamoz", "TR23098", "01998763");
//	
//		Booking b1 = new Economy(p2, f1);
		
//		System.out.println(b1.getBookingId());

		p1.books("AQ21", s);
		
//		System.out.println(p1.getBookings().get(0).getBookingId());
		
		System.out.println(f1.getBookings().get(0).getBookingId());

		
		p1.checkIn("PS0BK0", s);
		p1.printBookings();
		
		Airline.printAllFlights();
	}

}
