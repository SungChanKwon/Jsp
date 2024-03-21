package com.saeyan.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "board/boardUpdate.jsp";
		
		String num = request.getParameter("num");
		
		BoardVO vo = BoardDAO.getInstance().
					selectOneBoardByNumber(Integer.parseInt(num));
		
		BoardDAO.getInstance().updateReadCount(Integer.parseInt(num)); //수정 횟수 증가
		
		request.setAttribute("board", vo);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
