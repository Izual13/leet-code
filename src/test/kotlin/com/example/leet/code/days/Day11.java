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

}
