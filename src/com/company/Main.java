package com.company;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

public class Main {

    public static void main(String[] args) {
        HttpClient httpClient = new DefaultHttpClient();
        try {
            JSONObject myJSON = returnJSON();
            HttpPost request = new HttpPost("http://127.0.0.1:23333");
            request.addHeader("content-type", "application/json");
            StringEntity params = new StringEntity(myJSON.toString());
            request.setEntity(params);
            System.out.println(params);

            HttpResponse response = httpClient.execute(request);
            System.out.println(response.getStatusLine());

        } catch (Exception ex) {
            System.out.println("Exception occurred");
            System.out.println(ex);
        } finally {
            System.out.println("Close connection");
            httpClient.getConnectionManager().shutdown();
        }
    }

    public static JSONObject returnJSON() {
        JSONObject myJSON = new JSONObject();
        myJSON.put("name", "Andy");
        myJSON.put("gender", "male");
        return myJSON;
    }
}
