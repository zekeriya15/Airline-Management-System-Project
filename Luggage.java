
public class Luggage {
	private int luggageId;
	private String type;
	
	public Luggage(int luggageId, String type) {
		this.luggageId = luggageId;
		this.type = type;
	}
	
//	getters
	public int getLuggageId() {
		return luggageId;
	}
	
	public String getType() {
		return type;
	}
	
//	setters
	public void setLuggageId(int id) {
		this.luggageId = id;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	
//	public void print() {
//		System.out.println("Luggage id: " + luggageId + "\nType: " + type);
//	}
	
	@Override
	public String toString() {
		return "Luggage id: " + luggageId + "\nType: " + type;
	}
}
