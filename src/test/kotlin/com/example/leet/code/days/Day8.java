package com.example.leet.code.days;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Day8 {

    //Simplify Path
    public String simplifyPath(String path) {
        List<String> result = new ArrayList<>();
        for(String s: path.split("/")){
            if(s.equals("..")){
                if(result.size()>0){
                    result.remove(result.size()-1);
                }
            }else if(!s.equals(".") && s.length()>0){
                result.add(s);
            }
        }

        return "/" + String.join("/", result);
    }
}
