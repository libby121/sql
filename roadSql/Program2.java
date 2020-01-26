package roadSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program2 {

	public static void main(String[] args) {

		DriverMoto doti = new DriverMoto(237, "amit", "A", 34);
		Motocycle moti = new Motocycle("motke", 1970,239);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//addDrivermOTO();
		//	addMoto(moti);
			deleteDrivermOTO(240);
		} catch (ClassNotFoundException e) {
			System.out.println("cannot find class " + e.getMessage());
		}}
//		try (Connection con = DriverManager.getConnection(
//				"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
//				"1234")) {
//			
//			PreparedStatement stmt1 = con
//					.prepareStatement("insert into drivers (id,name,licenseType,age)values (?,?,?,?)");
//			stmt1.setInt(1, doti.getId());
//			stmt1.setString(2, doti.getName());
//			stmt1.setString(3, doti.getLicenseType());
//			stmt1.setInt(4, doti.getAge());
//			
//			PreparedStatement stmt2 = con
//					.prepareStatement("update motocycle set driver_id=236 where id=4");
//			stmt2.execute();
//			System.out.println("driverID set");
//			
//			PreparedStatement stmt = con
//					.prepareStatement("insert into motocycle (model,year)values (?,?)");
//			stmt.setString(1, moti.getModel());
//			stmt.setInt(2, moti.getYear());
//			//stmt.setInt(3, moti.getDriverID());//cannot set the FK when a moto inserted. can only do it as an update
//			stmt.execute();
//			stmt1.execute();
//			
//			System.out.println("a new motoCycle inserted!");
//			System.out.println("a new motoDriver inserted!");
//		} catch (SQLException e) {
//			System.out.println("error!" + e.getMessage());
//
//		}}
	
	
public static void deleteDrivermOTO(int id){
		
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")) {
			
	PreparedStatement stmt = con
			.prepareStatement("delete from drivers where id="+id);
	
	stmt.execute();
	System.out.println("a driver deleted from table");
	
} catch (SQLException e) {System.out.println("error!"+e.getMessage());
}}
	
	public static void addDrivermOTO(){
		
		try (Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
				"1234")) {
			
	PreparedStatement stmt = con
			.prepareStatement("insert into drivers (id, name, licenseType,age)values (?,?,?,?)");
	stmt.setInt(1, 239);
	stmt.setString(2,"maya");
	stmt.setString(3, "A3");
	stmt.setInt(4, 45);
	stmt.execute();
	
} catch (SQLException e) {System.out.println("error!"+e.getMessage());
}}
public static void addMoto(Motocycle cyci){
	
	try (Connection con = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/road?serverTimezone=UTC", "root",
			"1234")) {
		
		PreparedStatement stmt = con
				.prepareStatement("insert into motocycle ( model, year,Driver_ID)values (?,?,?)");
		
		stmt.setString(1,cyci.getModel());
		stmt.setInt(2, cyci.getYear());
		stmt.setInt(3, cyci.getDriverID());
		
		stmt.execute();
		System.out.println("a new motoCycle in the table");
		
	} catch (SQLException e) {System.out.println("error!"+e.getMessage());
	}}}