package main.java.co.study.jdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

import main.java.co.study.jdbc.util.DBConnection;

public class JdbcTest1 {
	public static void main(String[] args) {
		Connection connection = DBConnection.getInstance().getConnection();

		String sql = "select * from score_mst";
		String sql1 = "select * from board_mst";
		try {
			PreparedStatement pstmt1 = connection.prepareStatement(sql1);
			ResultSet rs1 = pstmt1.executeQuery();
			System.out.println("id\t\t title\t\t content\t\tread+count");
			while (rs1.next()) {
				System.out.println("id : " + rs1.getInt(1) + "\t title : " + rs1.getString(2) + "\t content : "
						+ rs1.getString(3)+"\t read_count: "+rs1.getInt(4));
	

			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			System.out.println("id\t\tname\t\tscore");
			while (rs.next()) {
				System.out
						.println("id : " + rs.getInt(1) + "\t name: " + rs.getString(2) + "\t score : " + rs.getInt(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
