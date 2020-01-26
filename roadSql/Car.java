package roadSql;

public class Car {

	
	private int id;
	private String model;
	private int year;
	private int driverID;
	
	
	
	public Car(int id, String model, int year, int driverID) {
		this.id = id;
		this.model = model;
		this.year = year;
		this.driverID = driverID;
	}
	public int getDriverID() {
		return driverID;
	}
	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}
	public Car(int id, String model, int year) {
		
		this.id = id;
		this.model = model;
		this.year = year;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", year=" + year
				+ ", driverID=" + driverID + "]";
	}
	
	
}
