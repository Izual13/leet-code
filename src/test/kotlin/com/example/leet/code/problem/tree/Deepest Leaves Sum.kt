package com.example.leet.code.problem.tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Deepest Leaves Sum` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val tree = TreeNode(1)
        tree.left = TreeNode(2)
        tree.right = TreeNode(3)

        tree.left!!.left = TreeNode(4)
        tree.left!!.right = TreeNode(5)

        tree.left!!.left!!.left = TreeNode(7)


        tree.right!!.right = TreeNode(6)
        tree.right!!.right!!.right = TreeNode(8)

        Assertions.assertEquals(15, deepestLeavesSum(tree))
    }


    private fun deepestLeavesSum(root: TreeNode?): Int {
        return levelOrder(root).last().sum()
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
