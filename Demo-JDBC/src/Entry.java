import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import mysql-connector-java-5.1.45-bin

public class Entry {

	
	public static void main(String[] args) throws SQLException, ClassNotFoundException{
		
//		TODO 1	Load JDBC Driver in main memory
		String jdbcDriver="com.mysql.jdbc.Driver";
		
		Class.forName(jdbcDriver);
		
		
//		TODO 2	Get DB connection using JDBC URL
//		JDBC URL : Main-Protocol:DB-Spec-Protocol:Database-Info
		
		String jdbcURL = "jdbc:mysql://localhost:3306/test";
		
		Connection dbConnection = DriverManager.getConnection(jdbcURL);
		
		System.out.println(dbConnection);
		
		
		
	}
	
}
