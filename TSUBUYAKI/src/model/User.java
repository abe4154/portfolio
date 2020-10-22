package model;

public class User {
	private String userID;
	private String pass;
	private String mail;
	private String name;
	private int age;

	public User(String userID, String pass, String mail, String name, int age) {
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
