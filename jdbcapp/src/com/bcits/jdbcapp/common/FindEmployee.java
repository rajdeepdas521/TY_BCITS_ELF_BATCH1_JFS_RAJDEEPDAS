package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mysql.jdbc.Driver;

public class FindEmployee {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet r = null;
		Statement st = null;
		try {
			// load the driver
			/*
			 * Driver d = new Driver(); DriverManager.registerDriver(d);
			 */
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			
			
			String url = "jdbc:mysql://localhost:3306/employee_management_info?user=root&password=root";
			// get the db connection via Driver
			con = DriverManager.getConnection(url);                        
			// issue Sql query via connection
			String sql = "select * from employee_primary_info"
					+ " where deptid=10";
			st = con.createStatement();
			r = st.executeQuery(sql);
// process the results return by the sql queries
			while (r.next()) {
				int id = r.getInt("EMPID");
				String name = r.getString("NAME");
				long num = r.getLong("MOBILENO");
				Date dob = r.getDate("DOB");
				Date doj = r.getDate("DOJ");
				int did = r.getInt("DEPTID");
				int sal = r.getInt("SALARY");

				System.out.println("Employee Id -->" + id);
				System.out.println("Name--->" + name);
				System.out.println("Mobile Number--->" + num);
				System.out.println("Date Of Birth--->" + dob);
				System.out.println("Date Of Joining--->" + doj);
				System.out.println("Department Id--->" + did);
				System.out.println("Salary--->" + sal);
				System.out.println("---------------------------------------------------------");

			}
		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			// close all jdbc objects
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (r != null) {
				try {
					r.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
