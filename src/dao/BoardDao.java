package dao;

import java.sql.Connection;

import dto.Board;

public class BoardDao {

	public void insert(Board board , Connection conn) {
		System.out.println("DB에 board정보를 저장 했습니다.");
	}

}