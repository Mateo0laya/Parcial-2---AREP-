package com.edu.eci.arep.parcial2;

import static spark.Spark.*;

public class Main {
    
    public static void main(String... args){

        // root is 'src/main/resources', so put files in 'src/main/resources/public'
        staticFiles.location("/public"); // Static files

        port(getPort());
        
        
        get("/", (req,res) -> return );
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 35000;
    }
    
}