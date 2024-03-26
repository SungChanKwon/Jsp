package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QnAReplyFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
		
		
		request.setAttribute("qnaNum", qnaNum);
		request.getRequestDispatcher("qna/QnAReply.jsp").forward(request, response);
		
	}

}
