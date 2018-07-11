<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Guestbook List</h1>
<br>
<a href="writeform">방명록 글쓰기</a><br>
<c:forEach items="${list}" var="guestbook">
${guestbook.id } <br>
${guestbook.name } <br>
<pre>${guestbook.content }</pre> <br>
${guestbook.regdate } <br>
<hr><br>
</c:forEach>
</body>
</html>