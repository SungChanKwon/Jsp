package com.ezen.cotroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ezen.dao.MovieDAO;
import com.ezen.dto.MovieVO;


//flow 3 !! 영화 삭제하기 deleteMovie
@WebServlet("/moviedelete.do")
public class MovieDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=utf-8");
		
		int code = Integer.parseInt(request.getParameter("code"));
		
		MovieVO vo = MovieDAO.getInstance().getOneMovie(code);
		
		request.setAttribute("movie", vo);
		
		request.getRequestDispatcher("movie/movieDelete.jsp")
			.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int code = Integer.parseInt(request.getParameter("code")); //코드값 가져오기
		
		MovieDAO.getInstance().deleteMovie(code); //코드값 넘기기
		
//		response.sendRedirect("movie/movieList.do");  ==> css 스타일서식 적용안됨 why?
		response.sendRedirect("movieList.do");
	}

}
