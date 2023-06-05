package com.example.leet.code.days;

public class Day14 {
    //Check If It Is a Straight Line
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length<=2){
            return true;
        }

        int x = coordinates[1][0] - coordinates[0][0];
        int y = coordinates[1][1] - coordinates[0][1];

        for(int i=1;i<coordinates.length;i++){
            int nx = coordinates[i][0] - coordinates[i-1][0];
            int ny = coordinates[i][1] - coordinates[i-1][1];

            if(ny*x!=y*nx){
                return false;
            }
        }

        return true;
    }
}
