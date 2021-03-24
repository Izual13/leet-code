package com.example.leet.code.problem.tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Maximum Depth of Binary Tree` {


    private class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {

        val root = TreeNode(3)

        val n1 = TreeNode(9)
        val n2 = TreeNode(20)
        val n3 = TreeNode(15)
        val n4 = TreeNode(7)

        root.left = n1
        root.right = n2

        n2.left = n3
        n2.right = n4

        Assertions.assertEquals(3, maxDepth(root))
    }

    @Test
    fun test2() {

        val root = TreeNode(3)

        val n1 = TreeNode(9)
        val n2 = TreeNode(20)
        val n3 = TreeNode(15)
        val n4 = TreeNode(7)
        val n5 = TreeNode(7)

        root.left = n1
        root.right = n2

        n2.left = n3
        n2.right = n4

        n4.right = n5

        Assertions.assertEquals(4, maxDepth(root))
    }


    private fun maxDepth(root: TreeNode?): Int {
        if (root == null) {
            return 0
        } else if (root.left == null && root.right == null) {
            return 1
        }

        val left = maxDepth(root.left) + 1
        val right = maxDepth(root.right) + 1

        return max(left, right)
    }
}