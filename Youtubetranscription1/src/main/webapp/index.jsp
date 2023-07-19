<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Youtube Transcript Summarizer</title>
    <link rel="stylesheet" href="style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
</head>
<body>     
   
     <header>
        <div class="logo">
            <a href="index.jsp">Youtube Transcript Summarizer</a>  
        </div>
        <nav>
          <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="about.jsp">About</a></li>
            <li><a href="contact.jsp">Contact</a></li>
          </ul>
        </nav>
      </header>



      <section class="body-section">
        <div class="container">
          <h1>Enter URL</h1>
          
          <form action="CaptionGrabberServelet" method="GET">
            <input type="text" placeholder="Paste your URL here" name="videoUrl">
            <br>
            <br>
            <button type="submit">Submit</button>
          </form>
          
         
        </div>
        
    
      </section>
      
   <script src="app.js"></script> 
    
    
    
    
    
    
</body>
</html>
