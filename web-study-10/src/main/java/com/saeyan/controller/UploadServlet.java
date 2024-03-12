package com.saeyan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		//저장 경로 , 여기를 바꿔주면 다운받는 경로가 바뀜
		String savePath = "upload";
		
		//최대 업로드 파일 크기 5MB로 제한
		int uploadFileSizeLimit = 5*1024*1024;
		String encType = "utf-8";
		
		ServletContext context = getServletContext();
		System.out.println("context : " + context);
		
		String uploadFilePath = context.getRealPath(savePath);//실제 파일 경로
		System.out.println("uploadFilePath : " + uploadFilePath);
		
		try {
			MultipartRequest multi = new MultipartRequest (  //cos.jar을 쓸려면 반드시 써줘야함
					request, //MultipartRequest 와 연결할 request객체
					uploadFilePath, //실제 파일경로
					uploadFileSizeLimit,
					encType,
					new DefaultFileRenamePolicy() // 같은 이름의 파일에 새로운 이름읇 부여함
					);
			
			//업로드된 파일의 이름 얻기
			String fileName = multi.getFilesystemName("uploadFile");
			
			if(fileName == null) {
				System.out.println("파일 업로드 되지 않았음");
			}else {
				out.println("<br>글쓴이 : " + multi.getParameter("name")); //"name"은 upload.jsp input태그의 name="name"을 받아온것임
				out.println("<br>제목 : " + multi.getParameter("title"));
				out.println("<br>파일명 : " + fileName);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
