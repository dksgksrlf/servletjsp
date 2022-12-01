package dao;

import java.sql.Connection;

import dto.User;

public class UserDao {
	public void insert(User user , Connection conn) {
		System.out.println("DB에 User정보를 저장 했습니다.");
	}
}
