package com.bcits.jdbcapp.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.mysql.jdbc.Driver;

public class MyFirstJdbcProgram {
	public static void main(String[] args) {
		Connection con = null;
		Statement smt=null;
		ResultSet rs=null;
		try {
			Driver dref = new Driver();
			DriverManager.registerDriver(dref);

			// 2.get the dbconnection via driver
			String dburl = "jdbc:mysql://localhost:3306/employee_management_info?user=root&password=root";
			con = DriverManager.getConnection(dburl);

///3.execute sql querry
			String qry = "select * from employee_primary_info";
			 smt = con.createStatement();
			 rs = smt.executeQuery(qry);

			while (rs.next()) {
				int employeeId = rs.getInt("EMPID");
				String employeeNM = rs.getString("NAME");
				double employeeSalary = rs.getDouble("SALARY");
				int departmentId = rs.getInt("DEPTID");
				Date joining = rs.getDate("DOJ");
				String email = rs.getString("OFFICIAL_MAILID");
				long mobile = rs.getLong("MOBILENO");
				Date dob = rs.getDate("DOB");
				int managerid = rs.getInt("MANAGERID");

				System.out.println("employee ID ==>" + employeeId);
				System.out.println("EmployeeName ===>" + employeeNM);
				System.out.println("EMployeeSalary====>" + employeeSalary);
				System.out.println("Department ID====>" + departmentId);
				System.out.println("joining Date===>" + joining);
				System.out.println("Email Id===>" + email);
				System.out.println("Mobile no===>" + mobile);
				System.out.println("Date Of Birth===>" + dob);
				System.out.println("Manager ID===>" + managerid);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 5.close all jdbc objects
			try {
				if(con!=null) {
					con.close();
				}
				if(rs!=null)
				{
					rs.close();
				}
				if(smt!=null)
				{
					smt.close();
				}
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			}

		}

	}
}
