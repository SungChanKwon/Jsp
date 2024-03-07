package unit05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8"); //항상 반드시 써줘야함
		
		String id = request.getParameter("id"); //getParameter는 파라미터 값을 항상 문자열 형태로만 얻어옴
		String password = request.getParameter("pass");
		String msg = null;
		
		if(id.equals("sample") && password.equals("1234")) {
			msg = "로그인 성공";
		}else {
			msg = "로그인 실패";
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><body>");
		
		out.println("<b>" + msg + "</b><br>");
		
		out.println("<a href ='javascript:history.go(-1)'>다시</a>"); //이전으로 돌아감
		
		out.println("</head></body></html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
