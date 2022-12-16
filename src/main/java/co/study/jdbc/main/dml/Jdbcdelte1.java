package main.java.co.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.co.study.jdbc.util.DBConnection;

public class Jdbcdelte1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("삭제할 계정의 id값을 입력하시오 :");
		int in = scanner.nextInt();
		scanner.nextLine();
		
		Connection con = DBConnection.getInstance().getConnection();
		String sql ="delete from user_mst where id=?  ";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, in);
			int successCount = pstmt.executeUpdate();
			if(successCount>0) {
			System.out.println(successCount+"건 삭제완료");
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
			
	}

}
