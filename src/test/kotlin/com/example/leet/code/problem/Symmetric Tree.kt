package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*


@Suppress("ClassName")
class `Symmetric Tree` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val t1 = TreeNode(1)
        t1.left = TreeNode(2)
        t1.right = TreeNode(2)

        t1.left!!.left = TreeNode(3)
        t1.left!!.right = TreeNode(4)

        t1.right!!.left = TreeNode(4)
        t1.right!!.right = TreeNode(3)


        Assertions.assertEquals(true, isSymmetric(t1))
    }

    @Test
    fun test2() {
        val t1 = TreeNode(1)
        t1.left = TreeNode(2)
        t1.right = TreeNode(3)

        Assertions.assertEquals(false, isSymmetric(t1))
    }


    @Test
    fun test3() {
        val t1 = TreeNode(1)
        t1.left = TreeNode(2)
        t1.right = TreeNode(2)

        t1.left!!.right = TreeNode(3)
        t1.right!!.right = TreeNode(3)

        Assertions.assertEquals(false, isSymmetric(t1))
    }

    @Test
    fun test4() {
        val t1 = TreeNode(2)

        t1.left = TreeNode(3)
        t1.right = TreeNode(3)

        t1.left!!.left = TreeNode(4)
        t1.left!!.right = TreeNode(5)

        t1.right!!.left = TreeNode(5)
        t1.right!!.right = TreeNode(4)

        t1.left!!.left!!.left = null
        t1.left!!.left!!.right = null
        t1.left!!.right!!.left = TreeNode(8)
        t1.left!!.right!!.right = TreeNode(9)

        t1.right!!.left!!.left = TreeNode(9)
        t1.right!!.left!!.right = TreeNode(8)
        t1.right!!.right!!.left = null
        t1.right!!.right!!.right = null


        Assertions.assertEquals(true, isSymmetric(t1))
    }

    @Test
    fun test5() {
        val t1 = TreeNode(9)

        t1.left = TreeNode(-42)
        t1.right = TreeNode(-42)

        t1.left!!.left = null
        t1.left!!.right = TreeNode(76)

        t1.right!!.left = TreeNode(76)
        t1.right!!.right = null

        t1.left!!.right!!.left = null
        t1.left!!.right!!.right = TreeNode(13)

        t1.right!!.left!!.left = null
        t1.right!!.left!!.right = TreeNode(13)

        Assertions.assertEquals(false, isSymmetric(t1))
    }


    private fun isSymmetric(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        if (root.left == null && root.right == null) {
            return true
        }

        if (root.left == null || root.right == null) {
            return false
        }

        val list = LinkedList<TreeNode?>()
        list.add(root.left!!)
        list.add(root.right!!)
        while (!list.isEmpty()) {
            val t1 = list.poll()
            val t2 = list.poll()
            if (t1 == null && t2 == null) {
                continue
            }
            if (t1 == null || t2 == null) {
                return false
            }
            if (t1.`val` != t2.`val`) {
                return false
            }
            list.add(t1.left)
            list.add(t2.right)
            list.add(t1.right)
            list.add(t2.left)
        }
        return true
    }


}