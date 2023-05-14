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
    <script src="https://www.youtube.com/iframe_api"></script>
    
    
    <style>
    
    #transcription{
    
          margin-left:30%;
    
    }
    
    #textarea{
    
        width:70vw;
        length:1000px;
    
    
    
           border-radius: 3px 3px black ;
           
           margin-left:15%;
           margin-top: 0%;
    
      font-size:18px;
    
    }
    
    button{
    width: 150px;
    height: 50px;
    font-size: 24px;
    font-weight: bold;
    background-color: #333;
    cursor: pointer;
    color: #fff;
    border: none;
    border-radius: 5px;
    margin-left:45%;
    margin-bottom:7%;
    margin-top:2%;
    
  }
  a{
      color:white;
  
  }
    
    
    </style>

</head>
<body>

    <header>
        <div class="logo">
          <a href="#">Youtube Transcript Summarizer</a>
        </div>
        <nav>
          <ul>
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Contact</a></li>
          </ul>
        </nav>
      </header>
      
      <div id="player"></div>
      
      
          <h2 id="transcription">Full transcription of Video</h2>
      
      <textarea id="textarea" name="text" rows="20" cols="50"><%= session.getAttribute("text") %></textarea>
      
      
      <button><a href="/Youtubetranscription1/index.jsp">back</a></button>




</body>
</html>