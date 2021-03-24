package com.example.leet.code.problem.tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Binary Tree Zigzag Level Order Traversal` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val tree = TreeNode(3)
        tree.left = TreeNode(9)
        tree.right = TreeNode(20)

        tree.right!!.left = TreeNode(15)
        tree.right!!.right = TreeNode(7)

        val levelOrder = zigzagLevelOrder(tree)

        Assertions.assertEquals(3, levelOrder.size)
        Assertions.assertEquals(arrayListOf(3), levelOrder[0])
        Assertions.assertEquals(arrayListOf(20, 9), levelOrder[1])
        Assertions.assertEquals(arrayListOf(15, 7), levelOrder[2])
    }

    @Test
    fun test2() {
        val tree = TreeNode(1)
        tree.left = TreeNode(2)
        tree.right = TreeNode(3)

        tree.left!!.left = TreeNode(4)
        tree.left!!.right = TreeNode(5)

        val levelOrder = zigzagLevelOrder(tree)

        Assertions.assertEquals(3, levelOrder.size)
        Assertions.assertEquals(arrayListOf(1), levelOrder[0])
        Assertions.assertEquals(arrayListOf(3, 2), levelOrder[1])
        Assertions.assertEquals(arrayListOf(4, 5), levelOrder[2])
    }

    @Test
    fun test3() {
        val tree = TreeNode(1)
        tree.left = TreeNode(2)
        tree.right = TreeNode(3)

        tree.left!!.left = TreeNode(4)
        tree.left!!.right = TreeNode(5)

        tree.right!!.left = TreeNode(6)
        tree.right!!.right = TreeNode(7)

        val levelOrder = zigzagLevelOrder(tree)

        Assertions.assertEquals(3, levelOrder.size)
        Assertions.assertEquals(arrayListOf(1), levelOrder[0])
        Assertions.assertEquals(arrayListOf(3, 2), levelOrder[1])
        Assertions.assertEquals(arrayListOf(4, 5, 6, 7), levelOrder[2])
    }

    private fun zigzagLevelOrder(root: TreeNode?, level: Int = 0, result: ArrayList<LinkedList<Int>> = ArrayList()): List<List<Int>> {
        if (root == null) {
            return result
        }

        if (result.size < level + 1) {
            result.add(LinkedList())
        }

        if (level.and(1) == 1) {
            result[level].addFirst(root.`val`)
        } else {
            result[level].addLast(root.`val`)
        }

        zigzagLevelOrder(root.left, level + 1, result)
        zigzagLevelOrder(root.right, level + 1, result)

        return result
    }

}
