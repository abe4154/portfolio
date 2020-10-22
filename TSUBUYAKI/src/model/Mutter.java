package model;

import java.io.Serializable;

@SuppressWarnings("unused")
public class Mutter {
	private int id;// ユーザーid
	private String userID;// ユーザー名
	private String text;// つぶやき内容
	private String date;// つぶやき日時

	public Mutter() {
	}

	public Mutter(String userName, String text) {
		this.userID = userName;
		this.text = text;
	}

	public Mutter(String userID, String text, String date) {
		this.userID = userID;
		this.text = text;
		this.date = date;
	}

	public String getUserID() {
		return this.userID;
	}

	public String getText() {
		return this.text;
	}

	public String getDate() {
		return this.date;
	}
}
