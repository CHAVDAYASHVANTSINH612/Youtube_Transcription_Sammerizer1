package com;


import java.io.BufferedReader;



import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;



import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;


import org.json.JSONObject;
import org.json.JSONStringer;

import com.google.gson.JsonObject;

import org.json.JSONObject;
import org.apache.commons.text.StringEscapeUtils;


// opeanai documentation : https://platform.openai.com/docs/api-reference/completions/create

public class OpenaiApi_summerization {
	
	public static String getSummary(String transcription) throws IOException {
		
		if(transcription==null || transcription=="") {
			return "OpenaiApi_summerization not got transcription of video";
		}
		
		String Instruction="summerize the youtube video transcription given below in 5 or less point wise  transcription: ";
		String text= Instruction+transcription;
        String url = "https://api.openai.com/v1/completions";
        String apiKey = "Your_openai_API_KEY";
        
        
        
        

     // Create a JSONObject and add the escaped text
     JSONObject jsonObject = new JSONObject();
     jsonObject.put("model", "text-davinci-003");
     jsonObject.put("prompt", text);
     jsonObject.put("max_tokens", 90);
     jsonObject.put("temperature", 0.2);

     // Get the JSON string from the JSONObject
      String payload1 = jsonObject.toString();
      
      //OR
            //    String payload = "{\n" +
            //    "  \"model\": \"text-davinci-003\",\n" +
            //    "  \"prompt\": \""+ text +"\",\n" +
            //    "  \"max_tokens\": 90,\n" +
            //    "  \"temperature\": 0.2\n" +
            //    "}";
        

        

        URL endpoint = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) endpoint.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + apiKey);
        connection.setDoOutput(true);

        DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
       // outputStream.writeBytes(payload);
        outputStream.writeBytes(payload1);
        outputStream.flush();
        outputStream.close();

        
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        BufferedReader reader;
        if (responseCode == HttpURLConnection.HTTP_OK) {
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        String line;
        StringBuilder response = new StringBuilder();
        
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // System.out.println("Response: " + response.toString());
        
        String responseString =response.toString();
        
      
        
        
 // convert json string to object and get particular value
                /*
              Response Format from openai :
                     {
                           "id": "cmpl-uqkvlQyYK7bGYrRHQ0eXlWi7",
                           "object": "text_completion",
                           "created": 1589478378,
                           "model": "text-davinci-003",
                           "choices": [
                                         {
                                           "text": "\n\nThis is indeed a test",
                                              "index": 0,
                                            "logprobs": null,
                                             "finish_reason": "length"
                                          }
                               ],
                          "usage": {
                                       "prompt_tokens": 5,
                                       "completion_tokens": 7,
                                       "total_tokens": 12
                                    }
                                    
                      }
         */
        
        JSONObject responseObject =new JSONObject(responseString);
        String text1 = responseObject.getJSONArray("choices").getJSONObject(0).getString("text");
        
        int token=responseObject.getJSONObject("usage").getInt("total_tokens");
        System.out.println("token used : "+token);
        
         return text1;
         
        
        
	}
	
	

}
