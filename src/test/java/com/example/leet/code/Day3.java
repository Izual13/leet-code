package com.example.leet.code;

public class Day3 {
    //Count Ways To Build Good Strings
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high+1];
        int module = 1_000_000_000+7;

        dp[0] = 1;

        for(int i=Math.min(zero, one);i<=high;i++){
            if(i>=zero){
                dp[i] = (dp[i]+dp[i-zero]) % module;
            }
            if(i>=one){
                dp[i] = (dp[i]+dp[i-one]) % module;
            }

        }

        int result=0;
        for(int i=low;i<=high;i++){
            result=(result + dp[i]) % module;
        }
        return result;
    }
}
