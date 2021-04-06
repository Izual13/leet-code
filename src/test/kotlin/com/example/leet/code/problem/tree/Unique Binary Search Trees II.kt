package com.example.leet.code.problem.tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Unique Binary Search Trees II` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val trees = generateTrees(3)

        Assertions.assertEquals(5, trees.size)
    }

    @Test
    fun test2() {
        val trees = generateTrees(0)
        Assertions.assertEquals(0, trees.size)
    }

    @Test
    fun test3() {
        val trees = generateTrees(1, 2..1)
        Assertions.assertEquals(1, trees.size)
        Assertions.assertNull(trees[0])
    }


    private fun generateTrees(n: Int, range: IntRange = 1..n): List<TreeNode?> {
        if (n == 0) {
            return emptyList()
        } else if (range.isEmpty()) {
            return arrayListOf(null)
        }
        val result: ArrayList<TreeNode> = ArrayList()

        for (mid in range) {
            val left = generateTrees(n, range.first..mid - 1)
            val right = generateTrees(n, (mid + 1)..range.last)

            for (l in left) {
                for (r in right) {
                    val root = TreeNode(mid)
                    root.left = l
                    root.right = r
                    result.add(root)
                }
            }
        }

        return result
    }

}
