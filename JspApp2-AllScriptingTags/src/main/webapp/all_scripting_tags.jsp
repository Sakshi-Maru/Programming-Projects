
<%! public String generateWishMessage(String user){
//get system Date abd Time
java.time.LocalDateTime ldt=java.time.LocalDateTime.now();
//get current hour of the day
int hour=ldt.getHour();
//generate wish message
if (hour<12)
  return "Good Morning::"+user;
else if (hour<16)
  return "Good Afternoon::"+user;
else if (hour<20)
	return "Good evening::"+user;
else
	return "Good Night::"+user;
}
%>

<h1 style="color:red;text-align:center"> Welcome to java server Pages </h1>
<br>
<h1 style="color:green"> Date and Time is:: <%=new java.util.Date() %></h1>
<% String name="raja"; %>
<br> <b>The wish message is ::<%=generateWishMessage(name) %></b>
  //http://localhost:8080/JspApp2-AllScriptingTags/all_scripting_tags.jsp