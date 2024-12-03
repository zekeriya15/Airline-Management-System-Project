
public class Business extends Passenger {
	private final int MAX_LUGGAGE = 4;
	private final double MAX_WEIGHT = 45;
	private int numOfLuggage;
	
	public Business(String firstName, String lastName, String passportNo, String phone) {
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
			System.out.println("\nMaximum of allowed luggages in Business Class is 4 and maximum weight is 45 kg\n");
		}
	}
	
	public int getNumOfLuggage() {
		return numOfLuggage;
	}
}
