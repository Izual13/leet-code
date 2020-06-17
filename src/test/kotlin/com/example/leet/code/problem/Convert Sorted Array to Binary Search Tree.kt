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

    private fun sortedArrayToBST(nums: IntArray, i: Int = 0, j: Int = nums.size): TreeNode? {
        if (nums.isEmpty() || i >= j) return null
        val mid = i + (j - i) / 2
        val tree = TreeNode(nums[mid])
        tree.left = sortedArrayToBST(nums, i, mid)
        tree.right = sortedArrayToBST(nums, mid + 1, j)
        return tree
    }
}
