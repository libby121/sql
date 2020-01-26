package roadSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Program {

	public static void main(String[] args) {

		Driver driver = new Driver("shabi", 350, "A2", 46);
		Car car1 = new Car(122, "chevi", 1930, 349);
		// ArrayList<Driver> drivers = new ArrayList<Driver>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// addDriver(driver);
			// getDriverbyID(1);
			// add`Car(car1);
			// deleteCar(127);
			 deleteDriver(347);
			// getCarByID(125);
			// getAllDrivers();
			
			//getDriversByLicenseType("'A1'");
			//getDriversByMaxAge(44);
			//getCarsByModel("'fer'");
			getCarsBetweenYears(1920,1930);
		
		} catch (ClassNotFoundException e) {
			System.out.println("Did not find class " + e.getMessage());
		}

	}
	
	public static ArrayList<Car>getCarsBetweenYears(int min,int max){
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")){
			PreparedStatement stmt= con.prepareStatement("select * from car where year between "+min+" and "+max);
			ResultSet et = stmt.executeQuery();
			ArrayList<Car>cars = new ArrayList<Car>();
			while(et.next()){
				Car c= new Car(et.getInt("id"),et.getString("model"),et.getInt("year"),et.getInt("driver_id"));
				cars.add(c);
				System.out.println(c);
				
			}return cars;
			
		} catch (SQLException e) {System.out.println("error!"+e.getMessage());
		
	}return null;}
	
	public static ArrayList<Car>getCarsByModel(String model){
		try(Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")){
			PreparedStatement stmt= con.prepareStatement("select * from car where model="+model);
			ResultSet et = stmt.executeQuery();
			ArrayList<Car>cars=new ArrayList<Car>();
			while(et.next()){
				Car c= new Car(et.getInt("id"),et.getString("model"),et.getInt("year"),et.getInt("driver_ID"));
				cars.add(c);
				System.out.println(c);
				
			}return cars;
			
		} catch (SQLException e) {System.out.println("error!"+e.getMessage());
	}return null;}

	public static ArrayList<Driver>getDriversByMaxAge(int maxAge){
		try(Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")){
			PreparedStatement stmt = con.prepareStatement("select *from driver where age<="+maxAge);
			ResultSet et = stmt.executeQuery();
			ArrayList<Driver> drivers = new ArrayList<Driver>();
			
			while(et.next()){
				Driver d= new Driver(et.getString("name"),et.getInt("ID"),et.getString("licenseType"),et.getInt("age"));
				drivers.add(d);
				System.out.println(d);
				
			}
			return drivers;
			
		} catch (SQLException e) {System.out.println("error!"+e.getMessage());
		}return null;
		
	}
	
	public static ArrayList<Driver> getDriversByLicenseType(String type) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")) {
			PreparedStatement tmt = con
					.prepareStatement("select * from driver where licenseType="+type);
							
			ArrayList<Driver> drivers = new ArrayList<Driver>();
			ResultSet et = tmt.executeQuery();

			while (et.next()) {
				Driver d=new Driver(et.getString("name"),et.getInt("id"),et.getInt("age"));
				drivers.add(d);
				System.out.println(d);
			}
			//System.out.println(drivers);
			return drivers;
		} catch (SQLException e) {
			System.out.println("error!" + e.getMessage());
		}return null;

	}

	public static ArrayList<Driver> getAllDrivers() {

		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")) {

			PreparedStatement stmt = con
					.prepareStatement("select *from driver");
			ResultSet st = stmt.executeQuery();
			ArrayList<Driver> drivers = new ArrayList<Driver>();
			while (st.next()) {

				Driver d = new Driver(st.getString("name"), st.getInt("id"),
						st.getString("licenseType"), st.getInt("age"));
				drivers.add(d);
				System.out.println(d);

			}
			return drivers;
		} catch (SQLException e) {
			System.out.println("error!" + e.getMessage());
		}
		return null;

	}

	public static Car getCarByID(int id) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")) {
			PreparedStatement stmt = con
					.prepareStatement("select* from car where id=" + id);
			ResultSet et = stmt.executeQuery();
			if (et.first()) {
				Car car = new Car(id, et.getString(2), et.getInt(3),
						et.getInt(4));
				System.out.println(car);
				return car;
			} else
				System.out.println("car not found");
			;

		} catch (SQLException e) {
			System.out.println("error!" + e.getMessage());
		}
		return null;

	}

	public static void deleteDriver(int id) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")) {

			PreparedStatement stmt = con
					.prepareStatement("delete from driver where id=" + id);
			stmt.execute();
			System.out.println("a driver deleted successfully!");

		} catch (SQLException e) {
			System.out.println("error!" + e.getMessage());
		}
	}

	public static void deleteCar(int id) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")) {

			PreparedStatement stmt = con
					.prepareStatement("delete from car where id=" + id);
			stmt.execute();
			System.out.println("car deleted successfully");
		} catch (SQLException e) {
			System.out.println("Error!" + e.getMessage());
		}
	}

	public static void addCar(Car car) {
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")) {

			PreparedStatement pet = con
					.prepareStatement("insert into car (id,model,year,driver_ID )values(?,?,?,?)");
			pet.setInt(1, car.getId());
			pet.setString(2, car.getModel());
			pet.setInt(3, car.getYear());
			pet.setInt(4, car.getDriverID());

			System.out.println("a car inseerted successfully!");

			pet.execute();

		} catch (SQLException e) {
			System.out.println("error!" + e.getMessage());
		}
	}

	public static Driver getDriverbyID(int id) {
		// Driver driver2=null;
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")) {

			PreparedStatement stmt = con
					.prepareStatement("select * from driver where id=" + id);
			ResultSet rt = stmt.executeQuery();

			if (rt.next()) {
				Driver driver2 = new Driver(rt.getString("name"),
						rt.getInt("id"), rt.getString("licenseType"),
						rt.getInt("age"));
				System.out.println(driver2);
				return driver2;
			}
			// if(driver2!=null){

			// }

			else
				System.out.println("driver not found");
			// stmt.execute();

		} catch (SQLException e) {
			System.out.println("error " + e.getMessage());
		}
		return null;
		// return driver2;
	}

	public static void addDriver(Driver driver) {

		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")) {

			PreparedStatement stmt = con
					.prepareStatement("insert into driver (id, name,licenseType, age)values(?,?,?,?)");
			stmt.setInt(1, driver.getId());
			stmt.setString(2, driver.getName());
			stmt.setString(3, driver.getLicenseType());
			stmt.setInt(4, driver.getAge());
			// stmt.setInt(5, driver.);
			stmt.execute();

		} catch (SQLException e) {
			System.out.println("error " + e.getMessage());
		}
	}

}
