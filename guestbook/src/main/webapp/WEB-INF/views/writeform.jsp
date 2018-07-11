<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form"
	prefix="form"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>방명록 글쓰기 폼</h1>
<br>
<form:form method="post" action="write" commandName="guestbookForm">
이름 : <form:input path="name" /><br>
	 <form:errors path="name" /><br>
내용 :
<form:textarea path="content" cols="50" rows="6"></form:textarea><br>
<form:errors path="content" /><br>
<input type="submit" value="확인"><br>
<a href="list">목록보기</a>
</form:form>
</body>
</html>