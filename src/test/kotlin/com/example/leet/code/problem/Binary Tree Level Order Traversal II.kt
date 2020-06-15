package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*


@Suppress("ClassName")
class `Binary Tree Level Order Traversal II` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    //    [3,9,20,null,null,15,7]
//    3
//   / \
//  9  20
//    /  \
//   15   7
//
//return its bottom-up level order traversal as:
//
//[
//  [15,7],
//  [9,20],
//  [3]
//]
    @Test
    fun test1() {
        val t1 = TreeNode(3)
        t1.left = TreeNode(9)
        t1.right = TreeNode(20)

        t1.right!!.left = TreeNode(15)
        t1.right!!.right = TreeNode(7)


        val levelOrderBottom = levelOrderBottom(t1)
        Assertions.assertEquals(15, levelOrderBottom[0][0])
        Assertions.assertEquals(7, levelOrderBottom[0][1])
        Assertions.assertEquals(9, levelOrderBottom[1][0])
        Assertions.assertEquals(20, levelOrderBottom[1][1])
        Assertions.assertEquals(3, levelOrderBottom[2][0])
    }

    @Test
    fun test2() {
        val t1 = TreeNode(1)
        t1.left = TreeNode(2)
        t1.right = TreeNode(3)

        t1.left!!.left = TreeNode(4)

        t1.right!!.right = TreeNode(5)
        val levelOrderBottom = levelOrderBottom(t1)
        Assertions.assertEquals(4, levelOrderBottom[0][0])
        Assertions.assertEquals(5, levelOrderBottom[0][1])
        Assertions.assertEquals(2, levelOrderBottom[1][0])
        Assertions.assertEquals(3, levelOrderBottom[1][1])
        Assertions.assertEquals(1, levelOrderBottom[2][0])
    }


    private fun levelOrderBottom(root: TreeNode?): List<List<Int>> {

        val result = LinkedList<LinkedList<Int>>()
        if (root == null) {
            return result
        }
        val list = LinkedList<Pair<Int, TreeNode?>>()
        list.push(0 to root)
        var tmp = -1
        while (!list.isEmpty()) {
            val p = list.pollLast()

            val level = p.first
            val v = p.second?.`val`

            if (v != null) {
                if (tmp != level) {
                    tmp++
                    result.push(LinkedList())
                }

                result.peekFirst().add(v)
            }


            if (p.second?.left != null) {
                list.push((p.first + 1) to p.second?.left)
            }
            if (p.second?.right != null) {
                list.push((p.first + 1) to p.second?.right)
            }

        }
        return result
    }


}