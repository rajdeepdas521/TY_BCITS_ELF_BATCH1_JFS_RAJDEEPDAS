package com.bcits.connection;

public class MainMethodClass {
	public static void main(String[] args) {
	//	ClassA ref = new ClassA();

		String str="one";
		Connection ref=DriverManager.getConnection(str);
		ref.print();
		
	}//End OF main
}//End Of Class
