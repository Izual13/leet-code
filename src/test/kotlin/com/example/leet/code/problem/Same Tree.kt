package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Same Tree` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val t1 = TreeNode(1)
        t1.left = TreeNode(2)
        t1.right = TreeNode(3)

        val t2 = TreeNode(1)
        t2.left = TreeNode(2)
        t2.right = TreeNode(3)

        Assertions.assertEquals(true, isSameTree(t1, t2))
    }

    @Test
    fun test2() {
        val t1 = TreeNode(1)
        t1.left = TreeNode(2)
        t1.right = TreeNode(3)

        val t2 = TreeNode(1)
        t2.right = TreeNode(3)

        Assertions.assertEquals(false, isSameTree(t1, t2))
    }


    private fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }

        if (p == null || q == null) {
            return false
        }

        if (p.`val` != q.`val`) {
            return false
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}