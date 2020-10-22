package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Mutter;

public class MutterDAO {

	private final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost/test_db?characterEncoding=UTF-8&serverTimezone=JST&useSSL=false";
	private final String DB_USER = "test_user";
	private final String DB_PASS = "test_pass";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Mutter> findAll() {
		List<Mutter> mutterList = new ArrayList<Mutter>();
		try {
			// JDBCドドライバの読み込み
			Class.forName(DRIVER_NAME);

			// データベースへの接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// SELECT文の準備
			String sql = "SELECT * FROM MUTTER3 ORDER BY DT DESC";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String userID = rs.getString("USER_ID");
				String text = rs.getString("TEXT");
				Timestamp dt = rs.getTimestamp("DT");

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH時MM分");
				String date = sdf.format(dt);

				Mutter mutter = new Mutter(userID, text, date);
				mutterList.add(mutter);
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

		return mutterList;
	}

	public boolean create(Mutter mutter) {
		int result = 0;
		try {
			// データベース接続
			conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			// insert文の準備
			String sql = "INSERT INTO MUTTER3(USER_ID, TEXT) VALUES(?,?)";
			ps = conn.prepareStatement(sql);

			// VALUES(?,?)に値をセット
			ps.setString(1, mutter.getUserID());
			ps.setString(2, mutter.getText());

			result = ps.executeUpdate();

		} catch (SQLException e) {
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
