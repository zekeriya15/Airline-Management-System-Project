
public class Business extends Passenger {
	private int MAX_LUGGAGE;
	private int numOfLuggage;
	
	public Business(int passengerId, String firstName, String lastName, String passportNo, String phone) {
		super(passengerId, firstName, lastName, passportNo, phone);
		this.MAX_LUGGAGE = 4;
	}
	
	@Override
	public void addLuggage(Luggage l) {
		if (numOfLuggage < MAX_LUGGAGE) {
			this.luggages.add(l);
			this.numOfLuggage++;
		} else {
			System.out.println("Maximum of allowed luggages in Business Class is 4");
		}
	}
}
