<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Addition of two number</title>
</head>
<body>
<% int num1  = Integer.parseInt(request.getParameter("num1")); 
int num2  = Integer.parseInt(request.getParameter("num2"));
int result = num1 + num2;
%>

<h1>The result is <%= result %></h1>
</body>
</html>