package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Symmetric Tree` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

//    1
//    / \
//    2   2
//    / \ / \
//    3  4 4  3

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

    //    [2,3,3,4,5,5,4,null,null,8,9,9,8]
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

    //  [9,-42,-42,null,76,76,null,null,13,null,13]
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

        if (root.left!!.`val` != root.right!!.`val`) {
            return false
        }

        val array1 = getlArray(root.left!!)
        val array2 = getrArray(root.right!!)

        if (array1.size != array2.size) {
            return false
        }

        for (i in array1.indices) {
            if (array1[i] == null && array2[i] == null) {
                continue
            }

            if (array1[i] != array2[i]) {
                return false
            }
        }


        return true
    }

    private fun getlArray(t: TreeNode?, result: ArrayList<Int?> = ArrayList()): List<Int?> {
        if (t == null) {
            return result
        }

//        if (t.left == null && t.right == null) {
//            return result
//        }

        result.add(t.left?.`val`)
        result.add(t.right?.`val`)

        getlArray(t.left, result)
        getlArray(t.right, result)

        return result
    }

    private fun getrArray(t: TreeNode?, result: ArrayList<Int?> = ArrayList()): List<Int?> {
        if (t == null) {
            return result
        }

//        if (t.left == null && t.right == null) {
//            return result
//        }

        result.add(t.right?.`val`)
        result.add(t.left?.`val`)

        getrArray(t.right, result)
        getrArray(t.left, result)

        return result
    }

}