package com.ott.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ott.dao.MemberDAO;
import com.ott.dto.MemberVO;

public class HeaderFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		MemberVO vo = MemberDAO.getInstance().getOneMember(userId);
		
		request.setAttribute("member", vo);
		request.getRequestDispatcher("header.jsp").forward(request, response);
	}

}
