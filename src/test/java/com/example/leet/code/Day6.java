package com.example.leet.code;

public class Day6 {

    //Sort the Students by Their Kth Score
    public int[][] sortTheStudents(int[][] score, int k) {
        return sortTheStudents(score, 0, score.length-1, k);
    }

    public int[][] sortTheStudents(int[][] score, int s, int e, int k) {
        if(e<=s){
            return score;
        }


        int pivot = score[e][k];
        int i=s-1;
        for(int j=s;j<e;j++){
            if(score[j][k]>pivot){
                i++;
                int[] tmp=score[i];
                score[i] = score[j];
                score[j] = tmp;
            }
        }
        i++;
        int[] tmp=score[i];
        score[i] = score[e];
        score[e] = tmp;

        sortTheStudents(score, s, i-1, k);
        sortTheStudents(score, i+1, e, k);

        return score;
    }
}
