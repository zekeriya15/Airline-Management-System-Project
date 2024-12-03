
public class Aircraft {
	private static final String CODE = "AF";
	
	private String aircraftId;
	private String model;
	private int capacity;
	
	public Aircraft(String model, int capacity) {
		this.aircraftId = CODE + generateId();
		this.model = model;
		this.capacity = capacity;
		
		Airline.addAircraft(this);
	}
	
	private static int generateId() {
		int id = 0;
		
		if (Airline.getAircrafts().size() != 0) {
			Aircraft lastIndexValue = Airline.getAircrafts().get(Airline.getAircrafts().size() - 1);
			String lastAircraftId = lastIndexValue.getAircraftId();
			String numValue = lastAircraftId.substring(CODE.length(), lastAircraftId.length());
			int numValueParsed = Integer.parseInt(numValue);
			
			id = ++numValueParsed;
		}
		
		return id;
	}
	
//	getters
	public String getAircraftId() {
		return aircraftId;
	}
	
	public String getModel() {
		return model;
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	
//	setters
	public void setAircraftId(String id) {
		this.aircraftId = id;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	public void print() {
		System.out.println(aircraftId + "\t\t" + model + "\t" + capacity);
	}
	
	@Override
	public String toString() {
		return "id: " + aircraftId +
				"\nAirline: " + Airline.getName() +
				"\nModel: " + model +
				"\nCapacity: " + capacity + " seats";
	}
	
	
}
