package com.marlabs.shoppingcart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

	static boolean regFlag = true;
	static Connection connection = null;
	static String uname;
	static String pword;
	static Statement statement = null;
	
	public static Connection getConnection() {
		
		
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/shopping_cart?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
					"root", "Admin@123");
			//?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		return connection;
	}
	
	public static boolean regFlag(String Username, String Password) throws SQLException {
		
		statement = connection.createStatement();
		
		uname = Username;
		pword = Password;
		
		final String SELECT_QUERY = "select * from users where username= '"+uname+" 'and password ='"+ pword+"'";
		
		ResultSet rs = statement.executeQuery(SELECT_QUERY);
		while(rs.next()) {
			regFlag = false;
		}
		
		return regFlag;		
	}
	
	public static ArrayList getItemsList(String userName) {
		uname = userName;
		//ArrayList<String> itemsList = new ArrayList<>();
		HashMap itemsList = new HashMap();
		try {
			if(regFlag(uname, pword)) {
				final String SELECT_QUERY2 = "select * from itemslist2";
				ResultSet rs = statement.executeQuery(SELECT_QUERY2);
				while(rs.next()) {
					System.out.println(rs.getString("name"));
					System.out.println(rs.getString("price"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemsList;
	}
	
}
