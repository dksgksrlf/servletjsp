package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dto.Board;
import util.Pager;

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

	public int countRows(Connection conn) throws Exception{
		String sql = "select count(*) from boards2";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs=pstmt.executeQuery();
		rs.next();
		int result=rs.getInt(1);
		rs.close();
		pstmt.close();
		return result;
	}

	public List<Board> selectPageList(Pager pager, Connection conn) throws Exception {
		List<Board> result = new ArrayList<>();
		String sql="select rnum ,bno,btitle,bcontent,bwriter,bdate,bhitcount " + 
				"from(" + 
				"    select rownum as rnum ,bno,btitle,bcontent,bwriter,bdate,bhitcount " + 
				"    from(" + 
				"        select  bno,btitle,bcontent,bwriter,bdate,bhitcount " + 
				"        from boards2 " + 
				"        order by bno desc " + 
				"    )" + 
				"    where rownum<=? " + 
				")" + 
				"where rnum>=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, pager.getEndRowNo());
		pstmt.setInt(2, pager.getStartRowNo());
		ResultSet rs=pstmt.executeQuery();
		
		while(rs.next()) {
			Board board = new Board();
			board.setBno(rs.getInt("bno"));
			board.setBtitle(rs.getString("btitle"));
			board.setBcontent(rs.getString("bcontent"));
			board.setBwriter(rs.getString("bwriter"));
			board.setBhitcount(rs.getInt("bhitcount"));
			board.setBdate(rs.getDate("bdate"));
			result.add(board);
		}
		return result;
	}

	public Board selectBoard(int bno, Connection conn)throws Exception {
		
		Board result = null;
		String sql="select bno,btitle,bcontent,bwriter,bdate,bhitcount,bfilename,bsavedname,bfiletype from boards2 where bno=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, bno);
		ResultSet rs=pstmt.executeQuery();
		
		if(rs.next()) {
			result=new Board();
			result.setBno(rs.getInt("bno"));
			result.setBtitle(rs.getString("btitle"));
			result.setBcontent(rs.getString("bcontent"));
			result.setBwriter(rs.getString("bwriter"));
			result.setBhitcount(rs.getInt("bhitcount"));
			result.setBdate(rs.getDate("bdate"));
			result.setBfileName(rs.getString("bfilename"));
			result.setBsavedName(rs.getString("bsavedname"));
			result.setBfileType(rs.getString("bfiletype"));
			
		}
		rs.close();
		pstmt.close();
		return result;
	}

}
