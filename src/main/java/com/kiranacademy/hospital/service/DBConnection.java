package com.kiranacademy.hospital.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	private static String driverClass = "";
	private static String url = "";
	private static String dname = "";
	private static String username = "";
	private static String password = "";
	private static String fileName = "src/main/resources/jdbc_info.properties";

	private static Connection con = null;

	private static void readDBInfo() {
		Properties properties = new Properties();
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(fileName);
			properties.load(fileInputStream);
			driverClass = properties.getProperty("driver_class");
			System.out.println("Driver Class Path -: " + driverClass);

			dname = properties.getProperty("dname");
			System.out.println("database name -: " + dname);

			url = properties.getProperty("url");
			System.out.println("url -: " + url);

			username = properties.getProperty("username");
			System.out.println("username -: " + username);

			password = properties.getProperty("password");
			System.out.println("password -: " + password);

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static Connection getConnection() {
		
		readDBInfo();

		try {
			Class.forName(driverClass);

			con = DriverManager.getConnection(url + dname, username, password);
			System.out.println("Success! -> Connection Establish.");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Failed! -> Connection NOT Establish.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed! -> Connection NOT Establish.");
		}
		return con;
	}
}
