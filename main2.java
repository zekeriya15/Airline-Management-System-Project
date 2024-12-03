
public class main2 {
	public static void main(String[] args) {
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
	}

}
