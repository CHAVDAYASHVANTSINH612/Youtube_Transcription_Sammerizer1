package com;

import java.io.IOException;


import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Document;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

@WebServlet("/CaptionGrabberServelet")
public class CaptionGrabberServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		 HttpSession session = request.getSession();
		 PrintWriter out= response.getWriter();
		try {
			
			//removing previous responses
			session.removeAttribute("text");
			session.removeAttribute("videoUrl");		
			
           String videoUrl=request.getParameter("videoUrl");
			
			session.setAttribute("videoUrl", videoUrl);
			
			String videoId= videoUrl.substring(videoUrl.indexOf("=")+1);
	
	
// Request the website
            String url = "https://www.captionsgrabber.com/8302/display-captions-as-text.00.php?id="+videoId+"&language=en"; 
            int timeoutMilliseconds = 15000; // Increase the timeout to 15 seconds
            
            Document document = Jsoup.connect(url).timeout(timeoutMilliseconds).get();

     // Extract the text from the specific HTML element
            Elements element = document.select("div#text");
            String text = element.text();
         
			
//if website go down OR no trial left 
          //  String text = "With its mix of flagship imaging and exceptional portability, the DJI Mavic Series has never stopped empowering creators. Now, it's time for another bold leap forward. Introducing Mavic 3 Pro and Mavic 3 Pro Cine. Pro and Pro Cine both feature three cameras for ultra-dynamic imaging. It starts with a 4/3 CMOS Hasselblad camera for outstanding image quality and color science. The upgraded 166mm tele camera offers seven times optical zoom and a wider f/3.4 aperture. It provides higher resolution* and can shoot 4K/60fps video. Having the tele lens is truly game-changing for me because I think especially while shooting wildlife, you want to try to capture the most authentic moments. So being able to film from a safe distance is really an amazing feature. The third camera is a new 70mm medium tele that supports three times optical zoom, up to 48MP resolution, and can shoot 4K/60fps and D-Log M video. The new three times tele lens is super helpful when you're trying to shoot in these urban environments, cause you can't always get super close to your subject, so it let's you just punch in and shoot from a bit further back so you're not disturbing anyone, and it also lets you shoot with more compression, so the backgrounds look a lot bigger and more dramatic and you get more parallax with your shots. The Cine version comes with a built-in 1TB SSD, and all three cameras are capable of recording in Apple ProRes for premium color fidelity. In addition to flexible, pro-level imaging, Mavic 3 Pro also provides industry-leading flight performance and intelligent features. Authentic imaging has the power to convey emotion, to inspire, and to freeze moments in time. Mavic 3 Pro delivers endless ways to ignite the sparks of creativity. So having three lenses built into the DJI Mavic 3 Pro allows me to get different angles and different shots that I didn’t really think were possible before. From the image quality to the insane variety of shots you can get, this drone really is a dream for visual storytellers. With its innovative triple-camera system, Mavic 3 Pro ushers in a new era of imaging and storytelling possibilities, allowing you to keep inspiration in focus.";
            
            session.setAttribute("text",text);
			
			
		
	            
            
            
 // requesting to Openai summary api
            
            if(text!=null || text!="") { 
            	
            	//out.println(text);
            
          String summary=  OpenaiApi_summerization.getSummary(text );
            
            
           
           session.setAttribute("summary", summary);
           
           response.sendRedirect("Result.jsp");
           
           
            
            }
            else {
            	out.println("caption not found on video");
            }
            
            
            
            
          
            
        } catch (IOException e) {
        	
            e.printStackTrace();
           
            out.println("Server error OR caption may not avilable on that video");
        }
  

}

	
	

}
