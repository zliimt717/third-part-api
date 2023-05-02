package com.javapractices.service;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
@Service
public class ExternalService {

    public String searchResult(String name) throws URISyntaxException, IOException {
        NameValuePair queryValuePair=new BasicNameValuePair("name",name);
        return sendHttpRequest(List.of(queryValuePair));
    }

//define sendHttpRequest method
   private String sendHttpRequest(List<NameValuePair> queryParams) throws URISyntaxException, IOException {
        //create an httpclient object
        CloseableHttpClient httpClient= HttpClients.createDefault();

        HttpGet httpGet=new HttpGet("https://low-carb-recipes.p.rapidapi.com/search");

        URI uri=new URIBuilder(httpGet.getURI())
                .addParameters(queryParams)
                .build();
        httpGet.setURI(uri);//"https://low-carb-recipes.p.rapidapi.com/search?name=xxx"
        httpGet.setHeader("Content-Type","application/json");
        httpGet.setHeader("X-RapidAPI-Key", "0d0cbfcc0dmsh308d4cdc45b6472p1f6d8fjsn224a7466ab44");
        httpGet.setHeader("X-RapidAPI-Host", "low-carb-recipes.p.rapidapi.com");

        CloseableHttpResponse httpResponse= httpClient.execute(httpGet);
        String responseBody= EntityUtils.toString(httpResponse.getEntity());
        httpClient.close();
        return responseBody;
    }

}
