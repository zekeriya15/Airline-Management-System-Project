
public class Aircraft {
	private int aircraftId;
	private String model;
	private int capacity;
	
	public Aircraft(int aircraftId, String model, int capacity) {
		this.aircraftId = aircraftId;
		this.model = model;
		this.capacity = capacity;
		
		Airline.addAircraft(this);
	}
	
//	getters
	public int getAircraftId() {
		return aircraftId;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	
	public String toString() {
		return "id: " + aircraftId +
				"\nAirline: " + Airline.getName() +
				"\nModel: " + model +
				"\nCapacity: " + capacity + " seats";
	}
}
