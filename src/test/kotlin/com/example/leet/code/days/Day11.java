package com.example.leet.code.days;

import java.util.*;

public class Day11 {

    //Binary Search Tree to Greater Sum Tree
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    int sum=0;
    public TreeNode bstToGst(TreeNode root) {
        if(root.right!=null){
            bstToGst(root.right);
        }
        root.val+=sum;
        sum=root.val;
        if(root.left!=null){
            bstToGst(root.left);
        }

        return root;
    }

    //Sum of Nodes with Even-Valued Grandparent

    public int sumEvenGrandparent(TreeNode root) {
        if(root==null){
            return 0;
        }
        int sum = 0;
        if((root.val & 1) != 1){
            sum+=getSum(root);
        }

        sum+=sumEvenGrandparent(root.left);
        sum+=sumEvenGrandparent(root.right);


        return sum;
    }

    int getSum(TreeNode root){
        int result=0;
        TreeNode l = root.left;
        TreeNode r = root.right;

        if(l!=null){
            if(l.left!=null){
                result+=l.left.val;
            }

            if(l.right!=null){
                result+=l.right.val;
            }
        }

        if(r!=null){
            if(r.left!=null){
                result+=r.left.val;
            }

            if(r.right!=null){
                result+=r.right.val;
            }
        }
        return result;
    }

}
