package main.java.co.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;                                                                                                            
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import main.java.co.study.jdbc.util.DBConnection;

public class JdbcInsert2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		List<String> usernameList = new ArrayList<>();
	
		while(true) {
			System.out.print("등록할 아이디 입력 : ");
			usernameList.add(scanner.nextLine());
			System.out.print("아이디를 추가로 등록하시겠습니까? (Y/y,취소하려면 아무키나 입력.)");
			String selected = scanner.nextLine();
			if(!"yY".contains(selected.isBlank() ? "n" : selected)) {
				break;
			}
		}	
		Connection con = DBConnection.getInstance().getConnection();
		String prefix = "insert into user_mst values";
		String valuesBody = "";
		String suffix = ";";
		
		
		for(int i= 0; i<usernameList.size(); i++) {
			valuesBody += "(0,?)";
			if(i<usernameList.size()-1) {
				valuesBody +=", ";
			}
		}
		for(int i = 0; i<usernameList.size();i++) {
		System.out.println("("+i+","+usernameList.get(i)+")");
		}
		try {
			PreparedStatement pstmt = con.prepareStatement(prefix+valuesBody+suffix);
			for(int i = 0;i<usernameList.size();i++) {
			pstmt.setString(i+1, usernameList.get(i));
			}
			int successCount = pstmt.executeUpdate();
			
//			getGeneratedKeys(); 
//			insert 후 키값 들고오는것 


			String sql = "select * from user_mst where id in (";

			PreparedStatement pstmt1;
			ResultSet keySet = pstmt.getGeneratedKeys();
			if(keySet.next()) {
				int rs1 = keySet.getInt(1);
				System.out.println(rs1 +"번 고객입력됨");
			}
			try {
				pstmt1 = con.prepareStatement(sql);
				ResultSet rs = pstmt1.executeQuery();
				while(rs.next()) {
					System.out.println(rs.getInt(1) + " | " + rs.getString(2));
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
