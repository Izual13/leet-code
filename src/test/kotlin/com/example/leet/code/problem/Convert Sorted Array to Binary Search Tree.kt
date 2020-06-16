package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Convert Sorted Array to Binary Search Tree` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val tree = sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9))
        Assertions.assertEquals(tree?.`val`, 0)
        Assertions.assertEquals(tree?.left?.`val`, -3)
        Assertions.assertEquals(tree?.right?.`val`, 9)
        Assertions.assertEquals(tree?.left?.left?.`val`, -10)
        Assertions.assertEquals(tree?.right?.left?.`val`, 5)
    }

    private fun sortedArrayToBST(nums: IntArray): TreeNode? {
        if (nums.isEmpty()) {
            return null
        }

        val middle = nums.size / 2
        val tree = TreeNode(nums[middle])

        left(nums, tree, 0, middle - 1)
        right(nums, tree, middle + 1, nums.size - 1)

        return tree
    }

    private fun left(nums: IntArray, root: TreeNode, i: Int, j: Int): TreeNode? {
        if (nums.isEmpty()) {
            return null
        } else if (i > j) {
            return null
        }

        val middle = (i + j + 1) / 2

        root.left = TreeNode(nums[middle])

        left(nums, root.left!!, i, middle - 1)
        right(nums, root.left!!, middle + 1, j)

        return root
    }

    private fun right(nums: IntArray, root: TreeNode, i: Int, j: Int): TreeNode? {
        if (nums.isEmpty()) {
            return null
        } else if (i > j) {
            return null
        }

        val middle = (i + j + 1) / 2

        root.right = TreeNode(nums[middle])

        left(nums, root.right!!, i, middle - 1)
        right(nums, root.right!!, middle + 1, j)

        return root
    }
}
