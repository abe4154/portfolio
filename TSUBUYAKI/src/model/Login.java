package model;

import java.io.Serializable;


@SuppressWarnings("unused")
public class Login {
	private String userID;//ユーザー名
	private String pass;//パスワード
	
	public Login() {}

	public Login(String userID, String pass) {
		this.userID = userID;
		this.pass = pass;
	}
	
	
	public String getUserID() {
		return this.userID;
	}
	public String getPass() {
		return this.pass;
	}
	
}
