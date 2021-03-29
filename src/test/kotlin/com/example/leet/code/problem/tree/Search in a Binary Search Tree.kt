package com.example.leet.code.problem.tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Search in a Binary Search Tree` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test2() {
        val tree = TreeNode(4)
        tree.left = TreeNode(2)
        tree.right = TreeNode(7)

        tree.left!!.left = TreeNode(1)
        tree.left!!.right = TreeNode(3)

        Assertions.assertEquals(2, searchBST(tree, 2)!!.`val`)
    }


    private fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return null
        }

        return when {
            root.`val` == `val` -> root
            root.`val` < `val` -> searchBST(root.right, `val`)
            else -> searchBST(root.left, `val`)
        }
    }

}
