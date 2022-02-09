package com.studentapp.model;

import java.sql.ResultSet;


public interface DAO {
	public void connectdb();
	public boolean verifyLoginCredentials(String email, String password);
	public void Registration(int id, String name, String city, String email, String mobile);
	public ResultSet getAllReg() ;
	public void deleteByEmail(String email);
	public void updateReg(String email, String mobile);
}