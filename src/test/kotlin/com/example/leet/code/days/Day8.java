package com.example.leet.code.days;

import java.util.ArrayList;
import java.util.List;

public class Day8 {

    //Simplify Path
    public String simplifyPath(String path) {
        path = path+"/";
        List<String> result=new ArrayList<>();

        int i=0;
        StringBuilder sb=new StringBuilder();
        while(i<path.length()){
            if(path.charAt(i)=='/'){
                if("..".contentEquals(sb)){
                    if(result.size()>0){
                        result.remove(result.size()-1);
                    }
                }else if(".".contentEquals(sb)){
                    //ignore
                }else if(sb.length()>0){
                    result.add(sb.toString());
                }

                sb.delete(0, sb.length());
            }else{
                sb.append(path.charAt(i));
            }
            i++;
        }

        sb.delete(0, sb.length());
        for(String s: result){
            sb.append("/");
            sb.append(s);
        }

        return sb.length()==0?"/":sb.toString();
    }
}
