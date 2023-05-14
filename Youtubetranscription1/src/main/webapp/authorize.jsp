<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h2>Authorize Application</h2>
    <p>To download captions, you need to authorize the application first:</p>
    <form action="https://accounts.google.com/o/oauth2/v2/auth?
 scope=https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fyoutube.readonly&
 access_type=offline&
 include_granted_scopes=true&
 state=state_parameter_passthrough_value&
 redirect_uri=http://localhost:8080/ByCap4/CaptionDownloadServlet&
 response_type=code&
 client_id=507145162565-crik33akohqv8mpbbbh6ktmd7edvj7rv.apps.googleusercontent.com">
        <button type="submit">Authorize</button>
    </form>

</body>
</html>