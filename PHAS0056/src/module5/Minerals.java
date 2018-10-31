package module5;

public class Minerals {

	//member variables
	private int UUID;
	private double mass;
	private String nameLoc;
	
	////Constructors
	
	public Minerals() {
		UUID = 0;
		mass = 0.0d;
		nameLoc = "";
	}
	
	public Minerals(int UUID, double mass) {
		this.UUID = UUID;
		this.mass = mass;
	}
	
	public Minerals(int UUID, String nameLoc) {
		this.UUID = UUID;
		this.nameLoc = nameLoc;
	}

	//// get methods for member variables
	public int getUUID() {
		return UUID;
	}

	public double getMass() {
		return mass;
	}

	public String getNameLoc() {
		return nameLoc;
	}
	
	
	
	
	
	
	
	
	
}
