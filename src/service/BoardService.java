package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.BoardDao;
import dto.Board;
import util.Pager;

public class BoardService {
	private ServletContext application;
	private DataSource ds;
	public BoardService(ServletContext application) {
		this.application=application;
		//방법1
		ds=(DataSource) application.getAttribute("dataSource");
		//방법2
		/*try {
			InitialContext ic = new InitialContext();
			ds = (DataSource)ic.lookup("java:comp/env/jdbc/java");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
	}
	public void write(Board board) {
		System.out.println("게시물을 저장합니다.");
		BoardDao boardDao= (BoardDao)application.getAttribute("boardDao");
		boardDao.insert1(board,null);
	}
	public void write2(Board board) {
		
		BoardDao boardDao= (BoardDao)application.getAttribute("boardDao");
		Connection conn=null;
		try {
			conn=ds.getConnection();
			boardDao.insert2(board,conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				
			}
		}
	}
	public int getTotalRows() {
		BoardDao boardDao = (BoardDao) application.getAttribute("boardDao");
		int result = 0;
		Connection conn=null;
		try {
			conn=ds.getConnection();
			result=boardDao.countRows(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public List<Board> getPageList(Pager pager) {
		BoardDao boardDao = (BoardDao) application.getAttribute("boardDao");
		List<Board> result = null;
		Connection conn=null;
		try {
			conn=ds.getConnection();
			result=boardDao.selectPageList(pager,conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
	public Board getBoard(int bno) {
		BoardDao boardDao = (BoardDao) application.getAttribute("boardDao");
		Board result = null;
		Connection conn=null;
		try {
			conn=ds.getConnection();
			result=boardDao.selectBoard(bno,conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
