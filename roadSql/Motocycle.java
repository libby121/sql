package roadSql;

public class Motocycle {

	private int id;
	private String model;
	private int driverID;
	private int year;

	public Motocycle(String model, int year, int driverID) {

		this.model = model;
		this.year = year;
		this.driverID = driverID;
	}
	
	public Motocycle (String model, int year){
		this.model=model;
		this.year=year;
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

	public void setAge(int age) {
		this.year = year;
	}

	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	@Override
	public String toString() {
		return "Motocycle [id=" + id + ", model=" + model + "year,=" + year
				+ ", driverID=" + driverID + "]";
	}

}
