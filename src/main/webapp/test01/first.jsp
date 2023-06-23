<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="result.jsp" method="post">
		<input type="hidden" name="param1" value="cat1.jpg" /><br>
		<input type="hidden" name="param2" value="dog2.jpg" /><br>
		<input type="hidden" name="param3" value="가을.jpg" /><br>
		<!-- 다운로드할 파일 이름을 매개변수로 전달함, -->
		<input type="submit" value="이미지 다운로드" />
	</form>
</body>
</html>