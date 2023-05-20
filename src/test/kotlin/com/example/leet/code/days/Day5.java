package com.example.leet.code.days;

public class Day5 {
    //Max Increase to Keep City Skyline
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] mr = new int[grid.length];
        int[] mc = new int[grid.length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                mr[i] = Math.max(mr[i], grid[i][j]);
                mc[j] = Math.max(mc[j], grid[i][j]);
            }
        }

        int result=0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                result+=Math.min(mr[i],mc[j])-grid[i][j];
            }
        }

        return result;
    }

    //Swapping Nodes in a Linked List
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    public ListNode swapNodes(ListNode head, int k) {
        ListNode f = head;
        ListNode s = head;


        for(int i=1;i<k;i++){
            f = f.next;
        }



        ListNode tmp = f;
        while(tmp.next!=null){
            tmp=tmp.next;
            s=s.next;
        }


        int tv = s.val;
        s.val = f.val;
        f.val = tv;

        return head;
    }
}
