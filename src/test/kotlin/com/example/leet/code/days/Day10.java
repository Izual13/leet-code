package com.example.leet.code.days;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day10 {
    //Stone Game II
    public int stoneGameII(int[] piles) {
        int[][] dp =new int[piles.length][piles.length];

        int[] sums =new int[piles.length];
        sums[piles.length-1] = piles[piles.length-1];
        for(int i=piles.length-2;i>=0;i--){
            sums[i]=sums[i+1]+piles[i];
        }


        return loop(0, 1, dp, sums);
    }

    int loop(int s, int m, int[][] dp, int[] sums){
        int size = sums.length;

        if(s+2*m>=size){
            return sums[s];
        }

        if(dp[s][m]==0){
            for(int i=1; i<=2*m; i++){
                dp[s][m] = Math.max(dp[s][m], sums[s] - loop(s+i,Math.max(i,m),dp,sums));
            }
        }
        return dp[s][m];
    }

    //Convert an Array Into a 2D Array With Conditions
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        int[] c = new int[nums.length+1];

        for(int n: nums){
            if(result.size()<++c[n]){
                result.add(new ArrayList<>());
            }
            result.get(c[n]-1).add(n);
        }

        return result;
    }

    //Group the People Given the Group Size They Belong To
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<groupSizes.length;i++){
            int max = groupSizes[i];
            List<Integer> l = map.computeIfAbsent(max, k -> new ArrayList<>());

            l.add(i);
            if(l.size()==max){
                result.add(new ArrayList<>(l));
                l.clear();
            }
        }

        return result;
    }
}
