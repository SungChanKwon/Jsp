<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/contentDetail.css">
<title>Insert title here</title>
</head>
<body>
	<header>
		<jsp:include page="../header.jsp"></jsp:include>
	</header>
	<section>
		<div id="wrap" align="center">
			<input type="hidden" name="page" value="${page.page}"> <input
				type="hidden" name="qnaNum" value="${qna.qnaNum}">
			<h1>문의 내용</h1>
			<div id="info">
				<table>
					<tr>
						<th>문의 제목</th>
						<td>${qna.qnaTitle}</td>
					</tr>
					<tr>
						<th>아이디</th>
						<td>${qna.userId}</td>
					</tr>
					<tr>
						<th>카테고리</th>
						<td>${qna.qnaCategory}</td>
					</tr>
					<tr>
						<th>등록 일자</th>
						<td>${qna.qnaRegiDate}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3">${qna.qnaContent}</td>
					</tr>
					<tr>
					<td colspan="2">
						<c:if test="${member.admin == 0}">
					<input type="submit" value="수정하기"
						onclick="OttServlet?command=qna_reply&qnaNum=${qna.qnaNum}">
					<input type="button" value="삭제하기" onclick="#">
				</c:if>
				
					</td>
					</tr>
					<tr>
						<td colspan="2">
							<div id="reply">
									<table>
								<c:if test="${member.admin == 1 && member.admin == 0 && !empty reply.replyNum}">
									<input type="hidden" name="qnaNum" value="${qna.qnaNum}">
											<tr>
												<th>문의 답변 드립니다.</th>
											</tr>
											<tr>
												<td>${reply.replyRegiDate}</td>
											</tr>
											<tr>
												<td>${qnaReply.replyContent}</td>
											</tr>
											<tr>
												<td colspan="2"></td>
											</tr>
								</c:if>
										</table>
								<c:if test="${member.admin == 1 && empty reply.replyNum}">
									<form action="OttServlet?command=qna_reply" method="post">
									<input type="hidden" name="qnaNum" value="${qna.qnaNum}">
										<table>
											<tr>
												<th>문의 답변 드립니다.</th>
											</tr>
											<tr>
												<td><textarea cols="70" rows="15" name="replyContent"></textarea></td>
											</tr>
											<tr>
												<td colspan="2"></td>
											</tr>
										</table>
										<br> <br> <input type="submit" value="등록"> 
										<input type="reset" value="다시 작성">
									</form>
								</c:if>
							</div>
						</td>
					</tr>
				</table>
				<input type="button" value="목록"
					onclick="location.href='OttServlet?command=qna_list&page=${page.page}'">
			</div>
		</div>
	</section>
	<footer>
		<jsp:include page="../footer.jsp"></jsp:include>
	</footer>
</body>
</html>