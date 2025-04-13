package dataBaseConnectionDetails;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {

	
	public Connection DBConnection() throws Exception {
		//connect to the DB
       Connection connect=null;
       String dbDetails= "jdbc:mysql://serverDetails:8080";
       String username="12344";
       String password="223344";
       
       connect = DriverManager.getConnection(dbDetails, username, password);
       System.out.println("connection established with the db " + dbDetails);
		
		return connect;
	}
}
