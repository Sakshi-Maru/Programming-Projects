<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
static{
	System.out.println("first.jsp:static block");
}
public void first_jsp(){
	System.out.println("first.jsp:0-param constructor");
}
public void jspInit(){
	System.out.println("first.jsp:jspInit()");
}
public void jspDestroy(){
	System.out.println("first.jsp:jspDestroy()");
}
%>

<% System.out.println("first.jsp_jspService(_,_) method"); %>
Date and time::<%=new java.util.Date() %>

</body>
</html>