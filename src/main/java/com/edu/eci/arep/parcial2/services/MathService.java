package com.edu.eci.arep.parcial2.services;

import static spark.Spark.*;

import java.util.ArrayList;
import java.util.List;

public class MathService {
    
    public static void main(String... args){
        
        
        port(getPort());
        
        get("linearsearch", (req,res) -> {

            String rawList = req.queryParams("list");
            String value = req.queryParams("value");
            
            int n = Integer.parseInt(value);

            String[] list = rawList.split(",");
            ArrayList ls = new ArrayList<Integer>();
            for(String s : list){
                ls.add(Integer.parseInt(s));
            }

            int i = linearSearch(ls, n);

            String response =   "{" + "\n" +
                                "operation: " + "linearsearch" + "\n" +
                                "inputlist:" + rawList + "\n" +
                                "value:" + value + "\n" +
                                "output:" + i + "\n" +
                                "}";

            System.out.println(response);
                                
            return response;

        });

        get("binarysearch", (req,res) -> {

            String rawList = req.queryParams("list");
            String value = req.queryParams("value");
            
            int n = Integer.parseInt(value);

            String[] list = rawList.split(",");
            ArrayList ls = new ArrayList<Integer>();
            for(String s : list){
                ls.add(Integer.parseInt(s));
            }

            int i = binarySearch(ls, n, 0);

            String response =   "{" + "\n" +
                                "operation: " + "binarySearch," + "\n" +
                                "inputlist: " + rawList + ",\n" +
                                "value: " + value + ",\n" +
                                "output: " + i + "\n" +
                                "}";

            System.out.println(response);
                                
            return response;

        });
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    private static int linearSearch(List<Integer> ls, int n) {
        int i = 1;
        int response = -1;
        for(int v : ls){
            if(v == n){
                response = i;
                break;
            }
            i++;
        }

        return response;
    }

    private static int binarySearch(List<Integer> ls, int n, int i) {
        int min = 0;
        int max = ls.size();

        if(ls.size()==1 && ls.get(0) != n){
            return -1;
        }

        int mid = max/2;

        if(ls.get(mid) == n){
            return mid+i;
        }
        else if (ls.get(mid) > n) {
            return binarySearch(ls.subList(0, mid), n, i);
        }

        else {
            return binarySearch(ls.subList(mid, max), n, mid+i);
        }
    }
    
}