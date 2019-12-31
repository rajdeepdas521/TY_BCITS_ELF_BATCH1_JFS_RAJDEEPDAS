package com.bcits.myproperties.common;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileWriter {
public static void main(String[] args) {
	try {
		FileOutputStream fs=new FileOutputStream("dbInfo.properties");
		Properties p=new Properties();
		p.setProperty("dirverName", "com.mysql.jdbc.Driver");
		p.setProperty("dbUrl", "jdbc:mysql://localhost:3306/employee_management_info");
		p.setProperty("user", "root");
		p.setProperty("Password", "root");
		try {
			p.store(fs, "Db Detail");
			System.out.println("File Created");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
}
}
