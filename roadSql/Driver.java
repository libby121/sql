package roadSql;

public class Driver {
	
	private String name;
	private int id;
	private String licenseType;
	private int age;

	
	public Driver(String name, int id, String licenseType, int age) {
		this.name = name;
		this.id = id;
		this.licenseType = licenseType;
		this.age = age;
	}


	public Driver(String name , int id, int age) {
		this.name=name;
		this.id=id;
		this.age=age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLicenseType() {
		return licenseType;
	}


	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Driver [name=" + name + ", id=" + id + ", licenseType="
				+ licenseType + ", age=" + age + "]";
	}
	
	

}
