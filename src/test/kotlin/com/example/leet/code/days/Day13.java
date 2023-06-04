package com.example.leet.code.days;

import java.util.*;

public class Day13 {

    //Subarray Sum Equals K
    public int subarraySum(int[] nums, int k) {
        int result=0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum=0;
        for(int n: nums){
            sum+=n;
            if(map.containsKey(sum-k)){
                result+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return result;
    }

}
