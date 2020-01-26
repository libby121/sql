package roadSql;

public class DriverMoto {
	
	private int id;
	private String name;
	private String licenseType;
	private int age;
	
	
	public DriverMoto(int id, String name, String licenseType, int age) {
		
		this.id = id;
		this.name = name;
		this.licenseType = licenseType;
		this.age = age;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
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
		return "DriverMoto [id=" + id + ", name=" + name + ", licenseType="
				+ licenseType + ", age=" + age + "]";
	}
	
	
	
	

}
