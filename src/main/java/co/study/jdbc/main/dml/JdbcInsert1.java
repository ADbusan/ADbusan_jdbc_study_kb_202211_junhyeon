package main.java.co.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.co.study.jdbc.util.DBConnection;

public class JdbcInsert1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.err.println("등록할 아이디 입력 : ");
		String username = scanner.nextLine();
		Connection con = DBConnection.getInstance().getConnection();
		String sql = "insert into user_mst values(0,?)";
		try {
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, username);
			int successCoiunt = pstmt.executeUpdate();
			System.out.println("데이터 "+ successCoiunt + "건 등록완료!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		select에만 씀 결과가보일때
//		ResultSet rs = pstmt.executeQuery();

		
	}

}
