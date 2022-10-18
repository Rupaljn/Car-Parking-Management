package com.rakuten.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

import com.rakuten.dto.Client;

public class ClientModel {
public boolean addClient(Client client){
	
	boolean flag = false;
	
	Integer id = client.getId();
	String name = client.getName();
	String emailId = client.getEmailId();
	String role = "CLIENT";
	String password = client.getPassword();
	Date createdDate = new Date();
	String createdBy = client.getCreatedBy();
	
	try{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/CarParkingManagement", "root", "root");
		PreparedStatement ps =  con.prepareStatement("insert into user(name, emailId, role, password, created_Date, created_By) values(?, ?, ?, ?, ?, ? )");
		ps.setString(1, name);
		ps.setString(2, emailId);
		ps.setString(3, role);
		ps.setString(4, password);
		ps.setDate(5, new java.sql.Date(createdDate.getTime()));
		ps.setString(6, createdBy);
		int row = ps.executeUpdate();
		if(row>0){
			flag = true;
		}
		con.close();
	}
	catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	catch(SQLException e){
		e.printStackTrace();
	}
	
	
	return flag;
}
}
