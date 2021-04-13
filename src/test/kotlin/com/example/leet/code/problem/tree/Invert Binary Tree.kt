package com.example.leet.code.problem.tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Invert Binary Tree` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val t1 = TreeNode(3)
        t1.left = TreeNode(9)
        t1.right = TreeNode(20)

        t1.right!!.left = TreeNode(15)
        t1.right!!.right = TreeNode(7)


        val tree = invertTree(t1)
        Assertions.assertEquals(3, tree!!.`val`)
        Assertions.assertEquals(20, tree.left!!.`val`)
        Assertions.assertEquals(9, tree.right!!.`val`)
        Assertions.assertEquals(7, tree.left!!.left!!.`val`)
        Assertions.assertEquals(15, tree.left!!.right!!.`val`)
    }

    private fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return root
        }

        val tmp = invertTree(root.left)
        root.left = invertTree(root.right)
        root.right = tmp

        return root
    }
}
