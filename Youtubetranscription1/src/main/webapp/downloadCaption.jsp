<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%

HttpSession session1 = request.getSession();

if(session1.getAttribute("accessToken") == null || session1.getAttribute("accessToken")=="" ) {
	response.sendRedirect("authorize.jsp");
}
%>


<h2>Download Captions</h2>
    <form action="CaptionDownloadServlet" method="POST">
        <label for="videoUrl">Enter YouTube Video URL:</label>
        <input type="text" id="videoUrl" name="videoUrl" required>
        <br>
        <button type="submit">Download Captions</button>
    </form>
    
    <%
    
    out.println(session1.getAttribute("accessToken"));
    
    
    %>


</body>
</html>