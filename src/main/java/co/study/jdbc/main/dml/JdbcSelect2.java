package main.java.co.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.co.study.jdbc.util.DBConnection;

public class JdbcSelect2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("작성자 id : ");
		int writer_id = scan.nextInt();
		Connection con = DBConnection.getInstance().getConnection();
		
//		쿼리문 !!
		String sql1 = "select * from board_mst where writer_id =  ?";
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql1);
			pstmt.setInt(1, writer_id);
			ResultSet rs1 = pstmt.executeQuery();
			System.out.println("id\t title\t\t content\t\tread+count \t\twriter_id");
			while (rs1.next()) {
				System.out.println("id : " + 
							rs1.getInt(1) + "\t title : " + 
							rs1.getString(2) + "\t content : "+
							rs1.getString(3) + "\t read_count : " +
							rs1.getInt(4) + "\t\t writer_id : "+
							rs1.getInt(5));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
