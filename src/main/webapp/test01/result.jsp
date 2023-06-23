<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, sec01.ex01.*" 
    isELIgnored="false" %>
    
    <%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
    
    <c:set var="contextPath" value="${pageContext.request.contextPath }"/>  
    
    <c:set var="file1" value="${param.param1}" />
	<c:set var="file2" value="${param.param2}" />
	<c:set var="file3" value="${param.param3}" />
	<!-- 다운로드할 파일 이름 가져옴 -->
</body> 	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	매개변수 1 : <c:out value="${file1}" /><br> 
	매개변수 2 : <c:out value="${file2}" /><br> 
	매개변수 3 : <c:out value="${file3}" /><br> 
	
	<c:if test="${not empty file1 }">
		<img src="${contextPath}/download.do?fileName=${file1}" width="300" height="300"/><br>
	</c:if> <!-- 파일 이름으로 서블릿에서 이미지를 다운로드 표시함 -->
	
	<c:if test="${not empty file2 }">
		<img src="${contextPath}/download.do?fileName=${file2}" width="300" height="300"/><br>
	</c:if>
	<c:if test="${not empty file3 }">
		<img src="${contextPath}/download.do?fileName=${file3}" width="300" height="300"/><br>
	</c:if>
	
	파일 내려받기 : <br>
	<a href="${contextPath}/download.do?fileName=${file1}">
	다운로드</a><br> <!-- 이미지를 파일로 다운로드 함 -->
	파일 내려받기 : <br>
	<a href="${contextPath}/download.do?fileName=${file2}">
	다운로드</a><br> <!-- 이미지를 파일로 다운로드 함 -->
	파일 내려받기 : <br>
	<a href="${contextPath}/download.do?fileName=${file3}">
	다운로드</a><br> <!-- 이미지를 파일로 다운로드 함 -->

	 
</html>