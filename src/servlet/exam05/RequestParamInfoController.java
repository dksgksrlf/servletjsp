package servlet.exam05;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="exam05.RequestParamInfoController",urlPatterns="/exam05/RequestParamInfoController")
public class RequestParamInfoController extends HttpServlet {
	//클라이언트가 요청할때 마다 콜백(요청 방식과는 상관없다.)
	//역할: 요청처리
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.getRequestDispatcher("/WEB-INF/views/exam05/requestParamInfo.jsp").forward(request,response);	
	}
	
		
}
