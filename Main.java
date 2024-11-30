
public class Main {
	public static void main(String[] args) {
		
//		create aircraft
		Aircraft plane = new Aircraft(1, "Airbus a380", 560);
		Aircraft plane2 = new Aircraft (2, "Airbus a350 neo", 340);
		
//		create flight, route, etc
		Flight f1 = new Flight(1, "A1", plane, "Doha", "New York");
		
		f1.setDepartureTime(2024, 12, 15, 7, 0);
		f1.setArrivalTime(2024, 12, 16, 1, 0);
		
		Flight f2 = new Flight(2, "A2", plane2, "Dublin", "Doha");
		
		f2.setDepartureTime(2024, 12, 28, 14, 0);
		f2.setArrivalTime(2024, 12, 28, 19, 0);
		
		
		Flight f3 = new Flight(3, "A2", plane2, "Doha", "Kiev");
		
		f3.setDepartureTime(2024, 11, 28, 14, 0);
		f3.setArrivalTime(2024, 11, 28, 19, 0);
		
//		create passnger
		Passenger p1 = new Economy(1, "Yakup", "Yakamoz", "A1", "0878");
		
//		add luggages
		p1.addLuggage(new Luggage(1, "small suitcase"));
		p1.addLuggage(new Luggage(2, "medium suitcase"));
		p1.addLuggage(new Luggage(3, "carry-on"));
		p1.addLuggage(new Luggage(4, "big carry-on"));
		
		System.out.println(p1.getNumOfLuggages());

		
		
//		
		
		
//		System.out.println(f1);
		
//		passenger books a flight
		p1.books(1, "A1");
		
//		passenger check in
		p1.checkIn("A1");
		
		
//		p1.print();
		
//		System.out.println(f1);
//		f1.printCheckedInPassengers();
		
//		Airline.findFlightsBydestination("New York");
		
//		Airline.printAllFlights();
//		
//		Airline.printAllAircrafts();
		
		
//		f2.cancelFlight();
//		
		Airline.printAllFlights();
		
//		Airline.printAllPassengers();
		
	}
}
