package com.example.leet.code.days;

import java.util.*;

public class Day7 {

//    Top K Frequent Elements

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        int[] result=new int[k];


        for(int n: nums){
            Integer e = map.get(n);
            if(e==null){
                map.put(n,1);
            }else{
                map.put(n, ++e);
            }
        }

        PriorityQueue<T> pq = new PriorityQueue<>(k, (p1,p2)-> Integer.compare(p2.c, p1.c));

        map.forEach((key,value)->{
            pq.add(new T(value,key));
        });

        for(int i=0;i<k;i++){
            result[i]=pq.poll().e;
        }

        return result;
    }

    static class T{
       public int c;
       public int e;

        T(int c, int e){
            this.c=c;
            this.e=e;
        }
    }
}
