package com.example.leet.code.days;

public class Day2 {
    //Solving Questions With Brainpower
    public long mostPoints(int[][] questions) {
        int n = questions.length - 1;
        long[] dp = new long[questions.length];

        for(int i = n; i>=0; i--){
            int q = questions[i][0];
            int s = questions[i][1];

            int prev = i+s+1;

            if(prev<=n){
                long best = Math.max(dp[i], q + dp[prev]);
                dp[i] = best;
            }else{
                dp[i] = q;
            }

            if(i!=n){
                dp[i] = Math.max(dp[i],dp[i+1]);
            }
        }

        return dp[0];
    }

    //Concatenation of Array
    public int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length*2];
        for(int i=0;i<result.length;i++){
            result[i] = nums[i % nums.length];
        }

        return result;
    }
}
