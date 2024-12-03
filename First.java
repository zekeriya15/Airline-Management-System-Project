
public class First extends Passenger {
	private final int MAX_LUGGAGE = 6;
	private final double MAX_WEIGHT = 55;
	private int numOfLuggage;
	
	public First(String firstName, String lastName, String passportNo, String phone) {
		super(firstName, lastName, passportNo, phone);
	}
	
	@Override
	public void addLuggage(Luggage l) {
		double currentWeight = 0;
		if (!luggages.isEmpty()) {
			for (Luggage lu : luggages) {
				currentWeight += lu.getWeight();
			}
		}
		
		double totalWeight = currentWeight + l.getWeight();
		
		if (numOfLuggage < MAX_LUGGAGE && totalWeight <= MAX_WEIGHT) {
			this.luggages.add(l);
			this.numOfLuggage++;
			
			System.out.println("\nLuggage added successfully\n");
		} else {
			System.out.println("\nMaximum of allowed luggages in First Class is 6 and maximum weight is 55 kg\n");
		}
	}
	
	public int getNumOfLuggage() {
		return numOfLuggage;
	}
}
