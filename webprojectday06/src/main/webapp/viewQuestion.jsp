<%@page import="webprojectday06.Question"%>
<%@page import="webprojectday06.Option"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="CalculateScoreServlet">
<%
	Question question = (Question) session.getAttribute("currentQs");
%>

<h3>Q. <%= question.getQuestion() %></h3>

<%
	List<Option> options = question.getOptions();
	for(int i=0; i<options.size(); i++) {
		Option option = options.get(i);
%>
		<div>
			<input type="radio" name="op" value="<%= i %>" />
			<%= option.getOption() %>
		</div>
<%
	}
%>
		
		
		<button type="submit">Next</button>
		</form>
		
</body>
</html>