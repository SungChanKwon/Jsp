<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.7.1.min.js"></script>
</head>
<body>
	<h2>정보 입력 폼</h2>
	<form method="post" action="itemWriteResult.jsp" id="form">
		<table>
			<tr>
				<td>상품명</td>
				<td><input type="text" name="name" size="20"></td>
			</tr>
			<tr>
				<td>가격</td>
				<td><input type="text" name="price" size="20">
				<td>
			</tr>
			<tr>
				<td>설명</td>
				<td><input type="text" name="description" size="100"
					style="height: 200px; text-align: auto"></td>
			</tr>
		</table>
		<input type="submit" value="전송"
			style="float: left; margin-left: 350px">
			 <input type="submit"
			name="name" value="취소" style="margin-left: 5px" id="resetBtn">
	</form>
	
	<script>
		$(function(){
			$('#resetBtn').click(function(e){
				e.preventDefault();
				$('#form').attr('action','itemDelete.jsp');
				$('#form').submit();				
			})
		})
	</script>
</body>
</html>