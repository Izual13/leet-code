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

    //n
    public int[] minOperations2(String boxes) {
        int size = boxes.length();
        int[] r = new int[size];
        int c=0;
        int o=0;

        for(int i=0;i<size;i++){
            r[i]+=o;
            c+=boxes.charAt(i)-'0';
            o+=c;
        }

        c=0;
        o=0;
        for(int i=size-1;i>=0;i--){
            r[i]+=o;
            c+=boxes.charAt(i)-'0';
            o+=c;
        }

        return r;
    }
}
