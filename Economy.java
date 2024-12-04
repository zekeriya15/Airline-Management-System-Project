
public class Economy extends Booking {
	private final int MAX_LUGGAGE = 2;
	private final double MAX_WEIGHT = 30;
	private int numOfLuggage;
	
	public Economy(Passenger p, Flight f) {
		super(p, f);
	}
	
	@Override
	public void addLuggage(Luggage l) {
		double currentWeight = 0;
		if (!this.luggages.isEmpty()) {
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
			System.out.println("\nMaximum of allowed luggages in Economy Class is 2 and maximum weight is 30 kg\n");
		}
	}
	
	public int getNumOfLuggage() {
		return numOfLuggage;
	}
	
	
}
