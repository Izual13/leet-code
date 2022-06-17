package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Lowest Common Ancestor of a Binary Tree` {

    class TreeNode(var `val`: Int = 0) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val t1 = TreeNode(1)
        val t2 = TreeNode(2)

        t1.left = t2


        Assertions.assertEquals(1, lowestCommonAncestor(t1, t1, t2)!!.`val`)
    }

    @Test
    fun test2() {
        val t0 = TreeNode(0)
        val t1 = TreeNode(1)
        val t2 = TreeNode(2)

        t0.left = t1
        t0.right = t2


        Assertions.assertEquals(0, lowestCommonAncestor(t0, t1, t2)!!.`val`)
    }


    @Test
    fun test3() {
        val t0 = TreeNode(0)
        val t1 = TreeNode(1)
        val t2 = TreeNode(2)
        val t3 = TreeNode(3)
        val t4 = TreeNode(4)
        val t5 = TreeNode(5)
        val t6 = TreeNode(6)
        val t7 = TreeNode(7)
        val t8 = TreeNode(8)

        t3.left = t5
        t3.right = t1

        t5.left = t6
        t5.right = t2

        t2.left = t7
        t2.right = t4

        t1.left = t0
        t1.right = t8

        Assertions.assertEquals(5, lowestCommonAncestor(t3, t5, t4)!!.`val`)
    }


    private fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }

        if (p?.`val` == root.`val` || q?.`val` == root.`val`) {
            return root
        }

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        if ((left?.`val` == p?.`val` && right?.`val` == q?.`val`) ||
            (right?.`val` == p?.`val` && left?.`val` == q?.`val`)
        ) {
            return root
        }

        if (left != null) {
            return left
        }

        if (right != null) {
            return right
        }

        return null
    }
}