<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%! public String generateWishMessage(String user){
	//get syatem date and time
	java.time.LocalDateTime ldt=java.time.LocalDateTime.now();
	//get current hour of the day
	int hour=ldt.getHour();
	//generate wish message
	if(hour<12)
		return"Good Morning::"+user;
	else if(hour<16)
		return"Good Afternoon::"+user;
	else if(hour<20)
		return"Good Evening::"+user;
	else 
		return"Good Night::"+user;
}
	%>
	
	<h1 style="color:red;text-align:center"> Welcome to Java Server Page </h1>
	<br>
	<h1 style="color:green;text-align:center"> Date and Time is ::<%=new java.util.Date() %> </h1>
	<% String name= "Sakshi"; %>
	<br> <b> The Wish Message is::<%=generateWishMessage(name)%></b>
	

</body>
</html>