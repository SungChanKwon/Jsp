package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.QnAReplyDAO;
import com.ott.dao.QnaDAO;
import com.ott.dto.QnAReplyVO;
import com.ott.dto.QnAVO;

public class QnAReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int qnaNum = Integer.parseInt(request.getParameter("qnaNum"));
		
		QnAVO qVo = QnaDAO.getInstance().getOneQna(qnaNum);
		
		QnAReplyDAO.getInstance().insertQnAReply();
		
		QnAReplyVO rVo = QnAReplyDAO.getInstance().getOneQnAReply(qnaNum);
		
		request.setAttribute("qna", qVo);
		request.setAttribute("reply", rVo);
		request.getRequestDispatcher("qna/QnADetail.jsp").forward(request, response);
	}

}
