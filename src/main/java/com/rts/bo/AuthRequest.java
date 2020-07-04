/**
 * 
 */
package com.rts.bo;

import java.io.Serializable;

public class AuthRequest implements Serializable {
private static final long serialVersionUID = -973137832406800324L;
	
	private String email;
	
	private String mobile;
	
	private String username;
	
	private String password;
	
	private String newPassword;
	
	private String oldPassword;

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	

}
