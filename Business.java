
public class Business extends Booking {
	private final int MAX_LUGGAGE = 4;
	private final double MAX_WEIGHT = 45;
	private int numOfLuggage;
	
	public Business(Passenger p, Flight f) {
		super(p, f);
	}
	

	public void addLuggage(Luggage l) {
		double currentWeight = 0;
		if (!passenger.getLuggages().isEmpty() && !this.luggages.isEmpty()) {
			for (Luggage lu : this.luggages) {
				currentWeight += lu.getWeight();
			}
		}
		
		double totalWeight = currentWeight + l.getWeight();
		
		if (numOfLuggage < MAX_LUGGAGE && totalWeight <= MAX_WEIGHT) {
			this.luggages.add(l);
			passenger.addLuggageToList(l);
			this.numOfLuggage++;
			
			System.out.println("\nLuggage added successfully\n");
		} else {
			System.out.println("\nMaximum of allowed luggages in Business Class is 4 and maximum weight is 45 kg\n");
		}
	}
	
	public int getNumOfLuggage() {
		return numOfLuggage;
	}
}
