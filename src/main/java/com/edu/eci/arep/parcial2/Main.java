package com.edu.eci.arep.parcial2;

import static spark.Spark.*;

public class Main {
    
    public static void main(String... args){

        // root is 'src/main/resources', so put files in 'src/main/resources/public'
        staticFiles.location("/public"); // Static files

        port(getPort());
        
        
        get("/linearsearch", (req,res) -> {

            String[] uri = req.uri().split("/");
            String type = uri[uri.length-1];
            String list = req.queryParams("list");
            String value = req.queryParams("value");

            String path = type + "?list=" + list + "&value=" + value;

            return RRInvoker.invoke(path);
        });

        get("/binarysearch", (req,res) -> {

            String[] uri = req.uri().split("/");
            String type = uri[uri.length-1];
            String list = req.queryParams("list");
            String value = req.queryParams("value");

            String path = type + "?list=" + list + "&value=" + value;

            return RRInvoker.invoke(path);
        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }
    
}