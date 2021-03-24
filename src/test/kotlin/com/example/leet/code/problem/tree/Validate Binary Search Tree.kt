package com.example.leet.code.problem.tree

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Validate Binary Search Tree` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val tree = TreeNode(2)
        tree.left = TreeNode(1)
        tree.right = TreeNode(3)

        Assertions.assertEquals(true, isValidBST(tree))
    }

    @Test
    fun test2() {
        val tree = TreeNode(5)
        tree.left = TreeNode(1)
        tree.right = TreeNode(4)

        tree.right!!.left = TreeNode(3)
        tree.right!!.right = TreeNode(6)

        Assertions.assertEquals(false, isValidBST(tree))
    }

    @Test
    fun test3() {
        val tree = TreeNode(5)
        tree.left = TreeNode(4)
        tree.right = TreeNode(6)

        tree.right!!.left = TreeNode(3)
        tree.right!!.right = TreeNode(7)

        Assertions.assertEquals(false, isValidBST(tree))
    }

    @Test
    fun test4() {
        val tree = TreeNode(5)
        tree.left = TreeNode(6)
        tree.right = TreeNode(7)

        Assertions.assertEquals(false, isValidBST(tree))
    }

    @Test
    fun test5() {
        val tree = TreeNode(5)
        tree.left = TreeNode(5)
        tree.right = TreeNode(7)

        Assertions.assertEquals(false, isValidBST(tree))
    }


    private fun isValidBST(root: TreeNode?): Boolean {
        if (root == null || (root.left == null && root.right == null)) {
            return true
        }

        val deque = ArrayDeque<TreeNode>()

        var head = root
        var prev: Int? = null


        while (deque.isNotEmpty() || head != null) {
            while (head != null) {
                deque.push(head)
                head = head.left
            }

            val first = deque.pop()

            if (prev != null && first.`val` <= prev) {
                return false
            }

            prev = first.`val`
            head = first.right
        }

        return true
    }

}
