/**
 * Quản lý Rạp chiếu phim RPP
 * Author: Nguyễn Tuấn - nguyentuanit96@gmail.com
 */
package rcp.util;

import java.sql.*;
import java.util.*;

import rcp.*;

public class Database {
	public static String hostName;
	public static String schemaName;
	public static String userName;
	public static String password;
	public static String connectionString;
	private static Connection connection;

	/**
	 * Nạp cài đặt lên Database
	 */
	public static void load() {
		hostName = (String) Settings.get("hostName");
		schemaName = (String) Settings.get("schemaName");
		userName = (String) Settings.get("userName");
		password = (String) Settings.get("password");
		connectionString = ((String) Settings.get("connectionString"));
	}

	/**
	 * Kết nối đến một CSDL cụ thể
	 * 
	 * @param jdbcString
	 * @param user
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public static Connection connect(String jdbcString, String user, String password) throws SQLException {
		return DriverManager.getConnection(jdbcString, user, password);
	}

	/**
	 * Kết nối đến CSDL trong cài đặt
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static Connection connect() throws SQLException {
		if (connection != null)
			return connection;
		else
			return DriverManager.getConnection(connectionString, userName, password);
	}

	/**
	 * Lấy danh sách các database trong server
	 * 
	 * @param hostName
	 * @param userName
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static ArrayList<String> getDatabasesList(String hostName, String userName, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connect = connect(String.format("jdbc:mysql://%1$s/sys?useSSL=false", hostName), userName, password);

		ResultSet rs = connect.getMetaData().getCatalogs();
		ArrayList<String> arr = new ArrayList<>();

		while (rs.next())
			arr.add(rs.getString("TABLE_CAT"));

		connect.close();

		return arr;
	}

	/**
	 * Sao lưu cơ sở dữ liệu
	 * 
	 * @param fileName
	 *            File cần lưu
	 * @return
	 * @throws Exception
	 */
	public static boolean backup(String fileName) throws Exception {
		// tạo lệnh sao lưu
		String executeCmd = String.format("\"%1$s\" -u%2$s -p%3$s -B %4$s -r \"%5$s\"",
				((String) Settings.get("mySQLBin")) + "\\mysqldump.exe", Database.userName, Database.password,
				Database.schemaName, fileName);

		// thực thi và trả kết quả
		Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
		return runtimeProcess.waitFor() == 0 ? true : false;
	}

	/**
	 * Phục hồi cơ sở dữ liệu
	 * 
	 * @param fileName
	 *            File cần phục hồi
	 * @return
	 * @throws Exception
	 */
	public static boolean restore(String fileName) throws Exception {
		// tạo lệnh phục hồi
		String[] executeCmd = new String[] { ((String) Settings.get("mySQLBin")) + "\\mysql.exe", Database.schemaName,
				"-u" + Database.userName, "-p" + Database.password, "-e", " source \"" + fileName + "\"" };

		// thực thi và trả kết quả
		Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
		return runtimeProcess.waitFor() == 0 ? true : false;

	}

	/**
	 * Gọi một stored
	 * 
	 * @param storeName
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet callStored(String storeName, Object... param) throws SQLException {
		// tạo chuỗi lời gọi
		StringBuilder statement = new StringBuilder("{call " + storeName + " ");
		if (param != null) {
			statement.append("(");
			for (int i = 1; i <= param.length; i++) {
				statement.append("?");
				if (i < param.length)
					statement.append(",");
			}
			statement.append(")");
		}
		statement.append("}");

		// kết nối và truyền tham số
		Connection connect = connect();
		CallableStatement call = connect.prepareCall(statement.toString());
		if (param != null) {
			for (int i = 1; i <= param.length; i++) {
				if (param[i - 1] != null)
					call.setObject(i, param[i - 1]);
				else
					call.setNull(i, Types.NULL);
			}
		}

		// trả về kết quả
		return call.executeQuery();
	}

	/**
	 * Gọi một stored để INSERT, UPDATE, DELETE
	 * 
	 * @param storeName
	 * @param param
	 * @return
	 * @throws SQLException
	 */
	public static int callStoredUpdate(String storeName, Object... param) throws SQLException {
		// tạo chuỗi lời gọi
		StringBuilder statement = new StringBuilder("{call " + storeName + " ");
		if (param != null) {
			statement.append("(");
			for (int i = 1; i <= param.length; i++) {
				statement.append("?");
				if (i < param.length)
					statement.append(",");
			}
			statement.append(")");
		}
		statement.append("}");

		// kết nối và truyền tham số
		Connection connect = connect();
		CallableStatement call = connect.prepareCall(statement.toString());
		if (param != null) {
			for (int i = 1; i <= param.length; i++) {
				if (param[i - 1] != null)
					call.setObject(i, param[i - 1]);
				else
					call.setNull(i, Types.NULL);
			}
		}

		// trả về kết quả
		return call.executeUpdate();
	}

}
