package com.anand.yellowpages.command;

/**
 * 
 * @author A Anand
 *
 */
public class LoginCommand {

	private String loginUserName;
	private String loginPassword;

	public LoginCommand(String loginUserName, String loginPassword) {
		super();
		this.loginUserName = loginUserName;
		this.loginPassword = loginPassword;
	}

	public LoginCommand() {
		super();
	}

	public String getLoginUserName() {
		return loginUserName;
	}

	public void setLoginUserName(String loginUserName) {
		this.loginUserName = loginUserName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public String toString() {
		return "LoginCommand [loginUserName=" + loginUserName + ", loginPassword=" + loginPassword + "]";
	}

}
