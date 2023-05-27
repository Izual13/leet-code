package com.example.leet.code.days;

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
}
