package unit01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("test/html; charset=utf-8"); // 항상 서두에 이 문장을 선언해줘야함 - 한글이 깨지기때문
		PrintWriter out = response.getWriter();
		out.println("<html><body><h1>");
		out.println("Hello Servlet<br>");
		out.println("헬로우 서블릿<br>");
		out.println("</h1></body></html>");
		out.close(); // 출력 스트림과 같은 자원들은 사용이 끝나면 이를 안전하게 닫아주는게 가장 좋음
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
