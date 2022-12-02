package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import dto.Board;

public class BoardDao {
	
	public int insert2(Board board , Connection conn) throws Exception {
		
			String sql="insert into boards2 (bno, btitle,bcontent , bwriter, bdate, bhitcount, bfilename, bsavedname , bfiletype)";
			sql += " values(seq_boards2_bno.nextval, ?,?,?, sysdate , 0,?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setString(4, board.getBfileName());
			pstmt.setString(5, board.getBsavedName());
			pstmt.setString(6, board.getBfileType());
			int rows = pstmt.executeUpdate();
			return rows;
		
	}

	public void insert1(Board board, Object object) {
		// TODO Auto-generated method stub
		System.out.println("DB에 Board를 저장합니다.");
	}

}
