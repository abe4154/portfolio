package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class RegisterUserDAO {

	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	private final String DB_USER = "test_user";
	private final String DB_PASS = "test_pass";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean ResistUser(User user) {

		int result = 0;
		try {
			// JDBCドドライバの読み込み
			Class.forName(DRIVER_NAME);

			
			// データベース接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// insert文の準備
			String sql = "INSERT INTO ACCOUNT(USER_ID, PASS, MAIL, NAME, AGE) VALUES(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);

			// VALUES(?,?)に値をセット
			ps.setString(1, user.getUserID());
			ps.setString(2, user.getPass());
			ps.setString(3, user.getMail());
			ps.setString(4, user.getName());
			ps.setInt(5, user.getAge());

			result = ps.executeUpdate();

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

		if (result != 1) {
			return false;
		} else {
			return true;
		}

	}

}
