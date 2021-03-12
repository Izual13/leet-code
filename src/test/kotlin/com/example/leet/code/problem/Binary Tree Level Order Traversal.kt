package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Binary Tree Level Order Traversal` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val tree = TreeNode(5)
        tree.left = TreeNode(9)
        tree.right = TreeNode(20)

        tree.right!!.left = TreeNode(15)
        tree.right!!.right = TreeNode(7)

        val levelOrder = levelOrder(tree)

        Assertions.assertEquals(3, levelOrder.size)
        Assertions.assertEquals(arrayListOf(5), levelOrder[0])
        Assertions.assertEquals(arrayListOf(9, 20), levelOrder[1])
        Assertions.assertEquals(arrayListOf(15, 7), levelOrder[2])
    }

    @Test
    fun test2() {
        val tree = TreeNode(1)
        tree.left = TreeNode(2)
        tree.right = TreeNode(3)

        tree.left!!.left = TreeNode(4)
        tree.left!!.right = TreeNode(5)

        val levelOrder = levelOrder(tree)

        Assertions.assertEquals(3, levelOrder.size)
        Assertions.assertEquals(arrayListOf(1), levelOrder[0])
        Assertions.assertEquals(arrayListOf(2, 3), levelOrder[1])
        Assertions.assertEquals(arrayListOf(4, 5), levelOrder[2])
    }

    private fun levelOrder(root: TreeNode?, level: Int = 0, result: ArrayList<ArrayList<Int>> = ArrayList()): List<List<Int>> {
        if (root == null) {
            return result
        }

        if (result.size < level + 1) {
            result.add(ArrayList())
        }

        result[level].add(root.`val`)

        levelOrder(root.left, level + 1, result)
        levelOrder(root.right, level + 1, result)

        return result
    }

}
