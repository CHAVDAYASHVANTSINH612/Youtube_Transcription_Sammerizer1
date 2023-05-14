package com;

import java.io.IOException;

import java.util.Map;
import java.util.LinkedHashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.*;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.auth.oauth2.TokenResponse;
import com.google.api.client.http.HttpTransport;

import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.Caption;
import com.google.api.services.youtube.model.CaptionListResponse;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.http.HttpResponse;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;

@WebServlet("/CaptionDownloadServlet")
public class GetYoutubeTranscription extends HttpServlet {
	  private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		
		String code=request.getParameter("code");
		PrintWriter out= response.getWriter();
		
		
		try {
			
	        // Your client ID and client secret
	        String clientId = "507145162565-crik33akohqv8mpbbbh6ktmd7edvj7rv.apps.googleusercontent.com";
	        String clientSecret = "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";
	        
	        // Scopes for the requested access
	        List<String> scopes = Arrays.asList("https://www.googleapis.com/auth/youtube.force-ssl");
	        
	        // The redirect URI configured for your application
	        String redirectUri = "http://localhost:8080/Youtubetranscription1/CaptionDownloadServlet";
	        
	        // Create the authorization code flow
	        HttpTransport httpTransport = new NetHttpTransport();
	        JsonFactory jsonFactory = new JacksonFactory();
	        
	        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
	                httpTransport, jsonFactory, clientId, clientSecret, scopes)
	                .setAccessType("offline") // Request offline access to get a refresh token
	                .setApprovalPrompt("force") // Always prompt the user for consent
	                .build();
	        
	        // Get the authorization code from the request parameter
	        String authorizationCode = request.getParameter("code");
	        
	        // Exchange the authorization code for an access token
	        TokenResponse tokenResponse = flow.newTokenRequest(authorizationCode)
	                .setRedirectUri(redirectUri)
	                .execute();
	        
	        // Get the access token and refresh token from the token response
	        final String accessToken = tokenResponse.getAccessToken();
	        String refreshToken = tokenResponse.getRefreshToken();
	        String apiKey = "AIzaSyA0SImaJ97rHpeIPo7C9tG2U1m6TwSi1I4";
	        
	        // Do something with the access token and refresh token
	        
	        HttpSession session= request.getSession();
	        
	        session.setAttribute("accessToken", accessToken);
	        session.setAttribute("refreshToken", refreshToken);
	        session.setAttribute("apiKey", apiKey);
	        
	        out.print(accessToken);
	       
	      //  response.sendRedirect("downloadCaption.jsp");
	        
	        
	        
	        
	        
	        
	        
	        
//	        HttpRequestInitializer initializer = new HttpRequestInitializer() {
//	            public void initialize(HttpRequest request) throws IOException {
//	                // Set your access token for authorization
//	                request.getHeaders().setAuthorization("Bearer "+accessToken);
//	            }
//	        };
//
//	        // Create an instance of the YouTube object
//	        YouTube youtube = new YouTube.Builder(httpTransport, jsonFactory, initializer)
//	                .setApplicationName("Your_Application_Name")
//	                .build();
//
//	        try {
//	            // Retrieve the captions for a specific video
//	            String videoId = "ROOeGPrC1Do";
//	            YouTube.Captions.List request1 = youtube.captions().list("snippet",videoId);
//	            
//	            CaptionListResponse captionListResponse = request1.execute();
//
//	            // Process the caption list response
//	            List<Caption> captions = captionListResponse.getItems();
//	            // Do something with the captions
//
//	            // Send the response to the client
//	            response.setContentType("text/html");
//	            
//	            out.println("<html><body>");
//	            out.println("Captions for video: " + videoId + "<br><br>");
//	            for (Caption caption : captions) {
//	                out.println("Caption ID: " + caption.getId() + "<br>");
//	                out.println("Caption: " + caption.getSnippet() + "<br><br>");
//	            }
//	            out.println("</body></html>");
//	        } catch (GoogleJsonResponseException e) {
//	            // Handle exception
//	            e.printStackTrace();
//	        }
	        
	        
	        
	        
	        
	        
	        
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
	}
}
	
	