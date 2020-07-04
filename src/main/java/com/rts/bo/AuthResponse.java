/**
 * 
 */
package com.rts.bo;

import java.io.Serializable;



public class AuthResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1306599275713505978L;
	
	private String accessToken;
	
	private String refreshToken;
	
	private Long expiresIn;
	
	private String lastLogeedInDate;
	
	private String userUniqueId;
	
	private String deviceUniqueId;
	
	private Integer isChangePasswordRequired;
	
	private Integer isPasswordExpired;

	private String firstName;
	
	private String lastName;
	
	private String email;
	
	private Long userId;
	
	private String themePreference;
	

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public Long getExpiresIn() {
		return expiresIn;
	}

	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}

	public String getLastLogeedInDate() {
		return lastLogeedInDate;
	}

	public void setLastLogeedInDate(String lastLogeedInDate) {
		this.lastLogeedInDate = lastLogeedInDate;
	}
	
	public String getUserUniqueId() {
		return userUniqueId;
	}

	public void setUserUniqueId(String userUniqueId) {
		this.userUniqueId = userUniqueId;
	}

	public String getDeviceUniqueId() {
		return deviceUniqueId;
	}

	public void setDeviceUniqueId(String deviceUniqueId) {
		this.deviceUniqueId = deviceUniqueId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getThemePreference() {
		return themePreference;
	}

	public void setThemePreference(String themePreference) {
		this.themePreference = themePreference;
	}

	

	public Integer getIsChangePasswordRequired() {
		return isChangePasswordRequired;
	}

	public void setIsChangePasswordRequired(Integer isChangePasswordRequired) {
		this.isChangePasswordRequired = isChangePasswordRequired;
	}

	public Integer getIsPasswordExpired() {
		return isPasswordExpired;
	}

	public void setIsPasswordExpired(Integer isPasswordExpired) {
		this.isPasswordExpired = isPasswordExpired;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accessToken == null) ? 0 : accessToken.hashCode());
		result = prime * result + ((refreshToken == null) ? 0 : refreshToken.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthResponse other = (AuthResponse) obj;
		if (accessToken == null) {
			if (other.accessToken != null)
				return false;
		} else if (!accessToken.equals(other.accessToken))
			return false;
		if (refreshToken == null) {
			if (other.refreshToken != null)
				return false;
		} else if (!refreshToken.equals(other.refreshToken))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AuthResponse [accessToken=" + accessToken + ", refreshToken=" + refreshToken + ", expiresIn="
				+ expiresIn + ", lastLogeedInDate=" + lastLogeedInDate + ", userUniqueId=" + userUniqueId
				+ ", deviceUniqueId=" + deviceUniqueId + "]";
	}

}
