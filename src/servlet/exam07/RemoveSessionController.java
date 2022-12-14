package servlet.exam07;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name="exam07.RemoveSessionController",urlPatterns="/exam07/RemoveSessionController")
public class RemoveSessionController extends HttpServlet {
	//클라이언트가 요청할때 마다 실행
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			
			//세션에 저장된 데이터(객체)를 제거
			session.removeAttribute("loginId");
			session.removeAttribute("loginDate");
			session.removeAttribute("cart");
			
			//HttpSession 객체 자체를 제거
			//session.invalidate();//자동으로 다시 생성
			response.sendRedirect("ContentController");
			
		}
		
		
}
