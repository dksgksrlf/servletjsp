package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;


@WebServlet(value="/Exam01Controller",loadOnStartup=1)
public class Exam01Controller extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Exam01Controller.init()실행");
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Exam01Controller.service()실행");
		//결과 생성
		List<Board> boards = new ArrayList<>();
		for(int i=1;i<=10;i++){
			Board board = new Board();
			board.setBno(i);
			board.setBtitle("제목"+i);
			board.setBcontent("내용"+i);
			board.setBwriter("홍길동");
			board.setBdate(new Date());
			boards.add(board);

		}
		//결과를 JSP에서 사용할수 있도록 설정
		request.setAttribute("list", boards);
		
		//JSP로 이동
		request.getRequestDispatcher("/WEB-INF/views/exam01_view.jsp").forward(request, response);
	}
	@Override
	public void destroy() {
		System.out.println("Exam01Controller.destroy() 실행");
	}
}
