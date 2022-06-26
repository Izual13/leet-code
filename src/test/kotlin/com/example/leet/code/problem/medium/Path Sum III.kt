package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.atomic.DoubleAccumulator

@Suppress("ClassName")
class `Path Sum III` {

    private class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    @Test
    fun test1() {

        val t1 = TreeNode(10)
        val t2 = TreeNode(5)
        val t3 = TreeNode(-3)
        val t4 = TreeNode(3)
        val t5 = TreeNode(2)
        val t6 = TreeNode(11)
        val t7 = TreeNode(3)
        val t8 = TreeNode(-2)
        val t9 = TreeNode(1)

        t1.left = t2
        t1.right = t3

        t2.left = t4
        t2.right = t5

        t3.right = t6

        t4.left = t7
        t4.right = t8

        t5.right = t9


        Assertions.assertEquals(3, pathSum(t1, 8))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(0, pathSum(null, 1))
    }


    @Test
    fun test3() {
        val t1 = TreeNode(5)
        val t2 = TreeNode(4)
        val t3 = TreeNode(8)
        val t4 = TreeNode(11)
        val t5 = TreeNode(13)
        val t6 = TreeNode(4)
        val t7 = TreeNode(7)
        val t8 = TreeNode(2)
        val t9 = TreeNode(5)
        val t10 = TreeNode(1)

        t1.left = t2
        t1.right = t3

        t2.left = t4

        t3.left = t5
        t3.right = t6

        t4.left = t7
        t4.right = t8

        t5.left = t9
        t5.right = t10

        Assertions.assertEquals(3, pathSum(t1, 22))
    }


    private fun pathSum(root: TreeNode?, targetSum: Int): Int {
        if (root == null) {
            return 0
        }

        var result = if (root.`val` == targetSum) 1 else 0

        result += pathSum(root.left, targetSum, root.`val`)
        result += pathSum(root.right, targetSum, root.`val`)

        result += pathSum(root.left, targetSum)
        result += pathSum(root.right, targetSum)


        return result
    }

    private fun pathSum(root: TreeNode?, targetSum: Int, accumulator: Int = 0): Int {
        if (root == null) {
            return 0
        }

        var result = if (root.`val` + accumulator == targetSum) 1 else 0

        result += pathSum(root.left, targetSum, root.`val` + accumulator)
        result += pathSum(root.right, targetSum, root.`val` + accumulator)
        return result
    }
}