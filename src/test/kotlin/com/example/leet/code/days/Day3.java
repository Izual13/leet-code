package com.example.leet.code.days;

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

    //Partitioning Into Minimum Number Of Deci-Binary Numbers
    public int minPartitions(String n) {
        char result = '0';
        for(int i=0;i < n.length();i++){
            char c = n.charAt(i);
            if(c=='9'){
                return 9;
            }else if(result<c){
                result=c;
            }
        }

        return result - '0';
    }
}
