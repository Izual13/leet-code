package com.example.leet.code.days;

public class Day12 {
    //Minimum Number of Operations to Move All Balls to Each Box
    //n^2
    public int[] minOperations(String boxes) {
        int[] result = new int[boxes.length()];
        for(int i=0;i<boxes.length();i++){
            int tmp=0;
            for(int j=0;j<boxes.length();j++){
                if(i==j||boxes.charAt(j)=='0'){
                    continue;
                }
                tmp+=Math.abs(i-j);
            }
            result[i]=tmp;
        }
        return result;
    }
}
