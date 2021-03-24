package com.example.leet.code.problem.tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Path Sum` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val tree = TreeNode(5)
        tree.left = TreeNode(4)
        tree.right = TreeNode(8)

        tree.left!!.left = TreeNode(11)

        tree.right!!.left = TreeNode(13)
        tree.right!!.right = TreeNode(4)


        tree.left!!.left!!.left = TreeNode(7)
        tree.left!!.left!!.right = TreeNode(2)

        tree.right!!.right!!.right = TreeNode(1)

        Assertions.assertEquals(true, hasPathSum(tree, 22))
    }

    private fun hasPathSum(root: TreeNode?, sum: Int, actual: Int = 0): Boolean {
        if (root == null) {
            return false
        }

        val newActual = root.`val` + actual
        if (sum == newActual && root.left == null && root.right == null) {
            return true
        }

        return hasPathSum(root.left, sum, newActual) || hasPathSum(root.right, sum, newActual)
    }
}
