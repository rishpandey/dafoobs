package com.bvp.daafobs.connectionprovider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionProvider {

	
	private static Connection con=null;
	Properties property=null;
	FileReader reader=null;
	static String driver=null;
	static String url=null;
	static String password =null;
	static String username =null;
	
	public static Connection getConnection(){
		try {
			Properties property =new Properties();
			FileReader reader=new FileReader("d:\\dba1.properties");
			property.load(reader);
			driver=property.getProperty("driver");
			url=property.getProperty("url");
			password=property.getProperty("password");
			username=property.getProperty("username");
			Class.forName(driver);
			con=DriverManager.getConnection(url,username,password); //establish connections
			System.out.println("connected");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
	
	
}
