package main.java.co.study.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.RequiredArgsConstructor;
import main.java.co.study.jdbc.entity.User;
import main.java.co.study.jdbc.util.DBConnectionMgr;

//@RequiredArgsConstructor
public class UserDao {

//	private final DBConnectionMgr pool;

//	상수이기때문에 계속 초기화
//	public UserDao(DBConnectionMgr pool) {
//		this.pool = pool;
//	}
	private DBConnectionMgr pool;

	public UserDao() {
		pool = DBConnectionMgr.getInstance();
	}

	public int insertUser(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int successCount = 0;
		ResultSet rs = null;

		try {
			con = pool.getConnection();
			sql = "insert into user_mst values(0,?)";
			pstmt = con.prepareCall(sql);
			pstmt.setString(1, user.getUsername());
			successCount = pstmt.executeUpdate();
			rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				user.setUser_id(rs.getInt(1));
				System.out.println(user);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
//			컬랙션을 끊어 주는거
		}
		return successCount;
	}

}
