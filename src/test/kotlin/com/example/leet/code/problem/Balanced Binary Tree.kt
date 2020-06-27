package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Balanced Binary Tree` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val tree = TreeNode(3)
        tree.left = TreeNode(9)
        tree.right = TreeNode(20)

        tree.right!!.left == TreeNode(15)
        tree.right!!.right == TreeNode(7)

        Assertions.assertEquals(true, isBalanced(tree))
    }

    @Test
    fun test2() {
        val tree = TreeNode(1)
        tree.left = TreeNode(2)
        tree.right = TreeNode(2)

        tree.left!!.left = TreeNode(3)
        tree.left!!.right = TreeNode(3)

        tree.left!!.left!!.left = TreeNode(4)
        tree.left!!.left!!.right = TreeNode(4)

        Assertions.assertEquals(false, isBalanced(tree))
    }

    @Test
    fun test3() {
        val tree = TreeNode(1)
        tree.right = TreeNode(3)
        tree.right!!.left = TreeNode(2)
        Assertions.assertEquals(false, isBalanced(tree))
    }

    @Test
    fun test4() {
        val tree = TreeNode(1)
        tree.left = TreeNode(2)
        tree.right = TreeNode(2)

        tree.left!!.left = TreeNode(3)
        tree.left!!.right = TreeNode(3)

        tree.right!!.left = TreeNode(3)
        tree.right!!.right = TreeNode(3)

        tree.left!!.left!!.left = TreeNode(4)
        tree.left!!.left!!.right = TreeNode(4)

        tree.left!!.right!!.left = TreeNode(4)
        tree.left!!.right!!.right = TreeNode(4)

        tree.right!!.left!!.left = TreeNode(4)
        tree.right!!.left!!.right = TreeNode(4)

        tree.left!!.left!!.left!!.left = TreeNode(5)
        tree.left!!.left!!.right!!.right = TreeNode(5)


        Assertions.assertEquals(true, isBalanced(tree))
    }

    @Test
    fun test5() {
        val tree = TreeNode(3)
        tree.left = TreeNode(9)
        tree.right = TreeNode(20)

        tree.right!!.left = TreeNode(15)
        tree.right!!.right = TreeNode(7)
        Assertions.assertEquals(true, isBalanced(tree))
    }

    private fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        return getDepth(root) > 0
    }

    private fun getDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val left = getDepth(root.left)
        val right = getDepth(root.right)

        if (left < 0 || right < 0) {
            return -1
        }

        if (Math.abs(left - right) > 1) {
            return -1
        }

        return Integer.max(left, right) + 1
    }


}
