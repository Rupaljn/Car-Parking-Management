package com.rakuten.dto;

import com.rakuten.exceptions.DataInvalidException;

public class Admin extends BaseBean{
private String name;
private String emailId;
private String role;
private String password;
public String getName() {
	return name;
}
public void setName(String name) {
	if(name.length()<3){
		throw new DataInvalidException("Name should be grater than three latter");
		
	}
	this.name = name;
}
public String getEmailId() {
	
    return emailId;
}
public void setEmailId(String emailId) {
	if(emailId.length()<3){
		throw new DataInvalidException("Please enter your complete email address");
		
	}
	this.emailId = emailId;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	if(password.length()<6){
		throw new DataInvalidException("Password should be grater than 6 charater");
	}
	this.password = password;
}

}
