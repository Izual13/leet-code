package com.example.leet.code;

public class Day4 {
    //Strictly Palindromic Number
    public boolean isStrictlyPalindromic(int n) {
        for(int i=2;i<=n-2;i++){
            String x = Integer.toString(n, i);
            if(!check(x)){
                return false;
            }
        }

        return true;
    }

    public boolean check(String s){
        int l = s.length();
        int p1 = 0;
        int p2 = l-1;
        while(p1<=p2){
            if(s.charAt(p1++)!=s.charAt(p2--)){
                return false;
            }
        }
        return true;
    }

    //Queries on Number of Points Inside a Circle

    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];

        for(int i=0; i<queries.length;i++){
            int[] q = queries[i];
            int x = q[0];
            int y = q[1];
            int r = q[2];

            int newY = y+r;

            //(x-x)(x-x) + (y-y)(y-y)

            double maxL = Math.sqrt((y-newY)*(y-newY));

            int c = 0;
            for(int[] p: points){
                double l = Math.sqrt((x-p[0])*(x-p[0])+(y-p[1])*(y-p[1]));
                if(maxL>=l){
                    c++;
                }
            }
            result[i] = c;
        }

        return result;
    }
}
