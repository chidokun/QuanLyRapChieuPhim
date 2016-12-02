package rcp.util;

import java.sql.*;
import java.util.*;

public class Database {
	
	public static Connection connect(String jdbcString, String user, String password) throws SQLException {	
		return DriverManager.getConnection(jdbcString, user, password);
	}
	
	public static ArrayList<String> getDatabasesList(String jdbcString, String user, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connect = connect(jdbcString, user, password);
		
		ResultSet rs = connect.createStatement().executeQuery("SHOW DATABASES");
		ArrayList<String> arr = new ArrayList<>();
		
		while(rs.next())
			arr.add(rs.getString("TABLE_CAT"));
				
		return arr; 
	}
}
