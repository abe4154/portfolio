package model;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Account {
	private String userID;// ユーザー名
	private String pass;// パスワード
	private String mail;// メールアドレス
	private String name;// 名前
	private int age;// 年齢

	public Account() {
	}

	public Account(String userID, String pass, String mail, String name, int age) {
		this.userID = userID;
		this.pass = pass;
		this.mail = mail;
		this.name = name;
		this.age = age;
		
	}

	public String getUserID() {
		return this.userID;
	}

	public String getPass() {
		return this.pass;
	}

	public String getMail() {
		return this.mail;
	}

	public String getName() {
		return this.name;
	}

	public int getAge() {
		return this.age;
	}

}
