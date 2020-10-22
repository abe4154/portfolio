package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Account;
import model.Login;

public class AccountDAO {

	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	private final String DB_USER = "test_user";
	private final String DB_PASS = "test_pass";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public Account findAc(Login login) {
		PreparedStatement ps = null;
		Account account = null;
		try {
			// JDBCドドライバの読み込み
			Class.forName(DRIVER_NAME);

			// データベースへの接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文の準備
			String sql = "SELECT USER_ID, PASS, MAIL, NAME, AGE FROM ACCOUNT WHERE USER_ID=? AND PASS=?";

			// SQL文をPreparedStatementにセット
			ps = conn.prepareStatement(sql);
			ps.setString(1, login.getUserID());
			ps.setString(2, login.getPass());

			// SQL送信と結果の取得
			rs = ps.executeQuery();

			if (rs.next()) {
				// 変数に受信したデータを保管
				String userID = rs.getString("USER_ID");
				String pass = rs.getString("PASS");
				String mail = rs.getString("MAIL");
				String name = rs.getString("NAME");
				int age = rs.getInt("AGE");

				account = new Account(userID, pass, mail, name, age);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// ---------------------
			// 5 接続の解除
			// ---------------------

			// ResultSetオブジェクトの接続解除

			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// PreapredStatementオブジェクトの接続解除
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			// Connectionオブジェクトの接続解除
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

		return account;
	}
}
