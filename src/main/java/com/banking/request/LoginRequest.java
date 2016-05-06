/**
 * 
 */
package com.banking.request;

/**
 * @author tbhendar
 *
 */
public class LoginRequest {
	private String userName;
	private String password;
	private String consumerKey;

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
