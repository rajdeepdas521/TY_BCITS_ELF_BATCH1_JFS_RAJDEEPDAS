package com.bcits.myproperties.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesFileReader {

	public static void main(String[] args) {
		try {
			FileInputStream finput=new FileInputStream("dbInfo.properties");
			Properties p2=new Properties();
			p2.load(finput);
			System.out.println("Driver Name-->"+p2.getProperty("dirverName"));
			System.out.println("User--------->"+p2.getProperty("user"));
			System.out.println("Db Url------->"+p2.getProperty("dbUrl"));
			
		} catch (Exception e) {

			e.printStackTrace(); 
            
		}

	}

}
