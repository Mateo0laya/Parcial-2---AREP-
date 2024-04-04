package com.edu.eci.arep.parcial2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RRInvoker {

    private static final String USER_AGENT = "Mozilla/5.0";
    private static String GET_URL = "";
    private static int turn = 1;

    public static String invoke(String path) throws IOException {

        setUrl(path);
        System.out.println(GET_URL);

        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            System.out.println("GET request not worked");
        }
        System.out.println("GET DONE");
        return "ok";
    }

    private static void setUrl(String path) {
        if(turn==1){
            turn = 2;
            GET_URL = "http://localhost:4567/" + path;
        } else {
            turn = 1;
            GET_URL = "http://localhost:4567/" + path;
        }
    }

} 