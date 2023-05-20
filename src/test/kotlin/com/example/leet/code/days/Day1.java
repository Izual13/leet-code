package com.example.leet.code.days;

import org.junit.jupiter.api.Test;

import java.util.*;
public class Day1 {
    //Integer to Roman
    public String intToRoman(int num) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");

        StringBuilder result = new StringBuilder();

        for(int i: Arrays.asList(1000,900,500,400,100,90,50,40,10, 9,5,4,1)){
            int x = num/i;
            for(int j=0; j<x;j++){
                result.append(map.get(i));
            }
            num-=x*i;
        }

        return result.toString();
    }

    //Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> cache = new HashMap<>();
        int result = 0;
        char[] chars = s.toCharArray();
        int start = 0;

        for(int i=0; i<chars.length; i++){
            Integer x = cache.get(chars[i]);
            if(x!=null){
                start=Math.max(start, x);
            }


            cache.put(chars[i], i+1);

            result = Math.max(cache.get(chars[i]) - start, result);
        }

        return result;
    }
}
