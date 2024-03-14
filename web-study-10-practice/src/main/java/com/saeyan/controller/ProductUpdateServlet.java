package com.saeyan.controller;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.saeyan.dao.ProductDAO;
import com.saeyan.dto.ProductVO;


//PRG 방식 생각하기!
@WebServlet("/productUpdate.do")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String code = request.getParameter("code");
		
		ProductVO vo = ProductDAO.getInstance()
				.selectProductByCode(Integer.parseInt(code));
		
		request.setAttribute("product", vo);
		
		String url = "product/productUpdate.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = getServletContext();
		String path = context.getRealPath("upload");
		String encType = "utf-8";
		int sizeLimit = 20*1024*1024;
		
		MultipartRequest multi = new MultipartRequest(
				request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		String code = multi.getParameter("code");
		String name = multi.getParameter("name");
		String price = multi.getParameter("price");
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		String description = multi.getParameter("description");
		
		if(pictureUrl == null) {
			pictureUrl = multi.getParameter("nonmakeImg");
		}
		
		ProductVO vo = new ProductVO();
		
		vo.setCode(Integer.parseInt(code));
		vo.setName(name);
		vo.setPrice(Integer.parseInt(price));
		vo.setPictureUrl(pictureUrl);
		vo.setDescription(description);
		
		ProductDAO pDao = ProductDAO.getInstance();
		pDao.updateProduct(vo);
		
		response.sendRedirect("productList.do");
		
	
	}

}
