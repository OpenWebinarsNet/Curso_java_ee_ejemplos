<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error JSP Page</title>
</head>
<body>
	<h1>Error</h1>
	<span style="color:#FF0000"><p>Sorry! username or password error</p></span>
	<%-- Se muestra sobre el index.jsp mediante la directiva include --%>
    <%@ include file="index.jsp" %>
</body>
</html>