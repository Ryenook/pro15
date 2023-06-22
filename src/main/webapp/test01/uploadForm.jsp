<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/pro15/upload.do" method="post" enctype="multipart/form-data" >
	<%-- 파일 업로드시 반드시 enctype을 multipart/form-data로 설정해야함 --%>
	
		파일1 : <input type="file" name="file1" ><br>
		파일2 : <input type="file" name="file2" ><br>
		파라미터1: <input type="text" name="param1" ><br>
		파라미터2: <input type="text" name="param1" ><br>
		<input type="submit" value="업로드"><br>
		
	
	</form>
	
</body>
</html>