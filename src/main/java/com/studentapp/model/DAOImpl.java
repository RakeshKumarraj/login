package com.studentapp.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.protocol.Resultset;

public class DAOImpl implements DAO {

	private Connection con;
	private Statement stat;
	
	@Override
	public boolean verifyLoginCredentials(String email, String password) {
		try {
			ResultSet result = stat.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
			return result.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void Registration(int id, String name, String city, String email, String mobile) {
		try {
		stat.executeUpdate("insert into registration values('"+id+"','"+name+"','"+city+"','"+email+"','"+mobile+"') ");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void connectdb() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentappdb", "root", "root");
			stat = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public ResultSet getAllReg() {
		try {
			ResultSet result = stat.executeQuery("select * from registration");
		return	result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteByEmail(String email) {
		try {
			stat.executeUpdate("Delete from registration where email='"+email+"'");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void updateReg(String email, String mobile) {
		try {
			stat.executeUpdate("UPDATE registration SET mobile = '"+mobile+"'  WHERE email='"+email+"'");
				
			} catch (Exception e) {
				e.printStackTrace();
			}		
	}

	
}
