package servlet.exam02;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//urlPatterns은 value와 같다
@WebServlet(name = "exam02.PostController", urlPatterns = "/exam02/PostController" )
public class PostController extends HttpServlet {
	//클라이언트가 POST방식으로 요철할때마다 콜백
	//역할: 요청처리
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/exam02/post.jsp").forward(request, response);
	}

}
