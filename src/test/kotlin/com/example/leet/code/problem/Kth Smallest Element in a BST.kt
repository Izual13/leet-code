package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Kth Smallest Element in a BST` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val tree = TreeNode(5)
        tree.left = TreeNode(3)
        tree.right = TreeNode(6)

        tree.left!!.left = TreeNode(2)
        tree.left!!.right = TreeNode(4)

        tree.left!!.left!!.left = TreeNode(1)


        Assertions.assertEquals(3, kthSmallest(tree, 3))
    }

    @Test
    fun test2() {
        val tree = TreeNode(5)
        tree.left = TreeNode(3)
        tree.right = TreeNode(6)

        tree.left!!.left = TreeNode(2)
        tree.left!!.right = TreeNode(4)

        tree.left!!.left!!.left = TreeNode(1)


        Assertions.assertEquals(1, kthSmallest(tree, 1))
    }

    private fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) {
            return -1
        }

        val deque = ArrayDeque<TreeNode>()

        var head = root
        var counter = 0

        while (deque.isNotEmpty() || head != null) {
            while (head != null) {
                deque.push(head)
                head = head.left
            }

            val first = deque.pop()

            if (++counter == k) {
                return first.`val`
            }

            head = first.right
        }

        return -1
    }
}
