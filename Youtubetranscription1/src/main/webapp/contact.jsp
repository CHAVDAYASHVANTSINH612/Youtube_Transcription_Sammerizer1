<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Contact | My Website</title>
  <link rel="stylesheet" href="styles.css">
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

  <section class="contact-section">
    <div class="container">
      <h2>Contact Us</h2>
      <p>For any inquiries or feedback, please fill out the form below and we'll get back to you as soon as possible.</p>
      <form>
        <input type="text" placeholder="Your Name">
        <input type="email" placeholder="Your Email">
        <textarea placeholder="Your Message"></textarea>
        <button type="submit">Submit</button>
      </form>
    </div>
  </section>

  <footer class="footer-section">
    <div class="container">
      <p>&copy; 2023 My Website. All Rights Reserved.</p>
      <div class="social-icons">
        <a href="#"><i class="fab fa-facebook-f"></i></a>
        <a href="#"><i class="fab fa-twitter"></i></a>
        <a href="#"><i class="fab fa-instagram"></i></a>
      </div>
    </div>
  </footer>
</body>
</html>
