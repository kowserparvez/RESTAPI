package com.qa.client;
import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class RestClient {
	 // Get Method
    public void get(String url) throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet(url); //http get request
        CloseableHttpResponse closebaleHttpResponse =  httpClient.execute(httpget); //hit the GET URL
       //Get status code
       int statusCode = closebaleHttpResponse.getStatusLine().getStatusCode();
       System.out.println("status code is : "+statusCode);
       //Get Json String
       String responseString = EntityUtils.toString(closebaleHttpResponse.getEntity(),"UTF-8");
       JSONObject responseJson = new JSONObject(responseString);
       System.out.println("Here is the response: " +responseJson);
       //All Headers
       Header[] headersArray =  closebaleHttpResponse.getAllHeaders();
       HashMap<String, String> allHeaders = new HashMap<String, String>();
       for(Header header : headersArray){
           allHeaders.put(header.getName(),header.getValue());
       }
        System.out.println("Headers : "+allHeaders);
    }
}
