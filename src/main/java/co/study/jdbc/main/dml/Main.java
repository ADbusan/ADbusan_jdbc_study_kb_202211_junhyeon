package main.java.co.study.jdbc.main.dml;

import main.java.co.study.jdbc.entity.User;
import main.java.co.study.jdbc.repository.UserDao;

public class Main {
	public static void main(String[] args) {
		UserDao dao = new UserDao();
		User user = User.builder()
				.username("abcd")
				.name("박준현")
				.phone("01099999999")
				.build();
		int result = dao.insertUser(user);
		System.out.println(result > 0 ? "user_id["+user.getUser_id( )+"] 등록완료 !": "등록실패 !");	
	}
}
