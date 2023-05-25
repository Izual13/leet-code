package com.example.leet.code.days;

import java.util.*;

public class Day9 {
    //Combinations
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        r(n,k,new ArrayList<Integer>(), result);
        return result;
    }

    public void r(int n, int k, List<Integer> c, List<List<Integer>> result) {
        if(c.size()==k){
            result.add(new ArrayList<>(c));
            return;
        }

        if(c.size()==0){
            for(int i=1;i<=n-k+1;i++){
                c.add(i);
                r(n,k,c,result);
                c.remove(c.size()-1);
            }
        }else{
            for(int i=c.get(c.size()-1)+1;i<=n;i++){
                c.add(i);
                r(n,k,c,result);
                c.remove(c.size()-1);
            }
        }
    }

}
