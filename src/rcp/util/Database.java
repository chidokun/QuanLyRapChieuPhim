package rcp.util;

import java.sql.*;
import java.util.*;

public class Database {
	public static String hostName = "";
	public static String schemaName = "";
	public static String userName = "root";
	public static String password = "root";
	public static String connectionString ="jdbc:mysql://127.0.0.1:3306/sys?autoReconnect=true&useSSL=false";
	
	public static Connection connect(String jdbcString, String user, String password) throws SQLException {	
		return DriverManager.getConnection(jdbcString, user, password);
	}
	
	public static ArrayList<String> getDatabasesList(String jdbcString, String user, String password) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection connect = connect(jdbcString, user, password);
		
		ResultSet rs = connect.getMetaData().getCatalogs();
		ArrayList<String> arr = new ArrayList<>();
		
		while(rs.next())
			arr.add(rs.getString("TABLE_CAT"));
		
		connect.close();
				
		return arr; 
	}
	
	public static void backup(String fileName) {
		
	}
	
	public static void restore(String fileName) {
		
	}
	
	public static ResultSet callStored(String storeName, Object... param) throws SQLException {
		StringBuilder statement = new StringBuilder("{call " + storeName + "(");
		for(int i = 1; i <= param.length; i++) {
			statement.append("?");
			if (i<param.length)
				statement.append(",");
		}
		statement.append(")}");
		
		Connection connect = connect(connectionString, userName, password);
		CallableStatement call = connect.prepareCall(statement.toString());
		for(int i = 1; i <= param.length; i++) {
			call.setObject(i, param[i]);
		}
		
		return call.executeQuery();		
	}
	

}
