<%@ page import="java.util.Collection" %>
<!DOCTYPE html>
<html lang="en">
	<body>
		<%
		
		Collection <String> movies = (Collection) request.getAttribute("movies");
		for(String mov : movies){
			
		%>
		<div><a href="Movies?name=<%=mov%>"><%=mov.toUpperCase()%></a></div><br>
		<%
		}
		%>
	</body>
</html>