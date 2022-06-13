package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.LinkedList

@Suppress("ClassName")
class `Flatten Binary Tree to Linked List` {

    private class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }


    @Test
    fun test1() {

        val root = TreeNode(1)
        val t2 = TreeNode(2)
        val t3 = TreeNode(3)
        val t4 = TreeNode(4)
        val t5 = TreeNode(5)

        root.left = t2
        root.right = t5

        t2.left = t3
        t2.right = t4

        flatten(root)

        Assertions.assertEquals(1, root.`val`)
        Assertions.assertEquals(2, root.right!!.`val`)
        Assertions.assertEquals(3, root.right!!.right!!.`val`)
        Assertions.assertEquals(4, root.right!!.right!!.right!!.`val`)
        Assertions.assertEquals(5, root.right!!.right!!.right!!.right!!.`val`)

        Assertions.assertNull(root.left)
        Assertions.assertNull(root.right!!.left)
        Assertions.assertNull(root.right!!.right!!.left)
        Assertions.assertNull(root.right!!.right!!.right!!.left)
        Assertions.assertNull(root.right!!.right!!.right!!.right!!.left)
        Assertions.assertNull(root.right!!.right!!.right!!.right!!.right)
    }

    @Test
    fun test2() {
        flatten(null)
    }


    private fun flatten(root: TreeNode?): Unit {
        if (root == null) {
            return
        }

        val stack = LinkedList<TreeNode>()

        stack.push(root)

        var stub = TreeNode(0)

        while (!stack.isEmpty()) {
            val node = stack.pop()

            if (node.right != null) {
                stack.push(node.right)
            }
            if (node.left != null) {
                stack.push(node.left)
            }

            stub.right = node
            stub.left = null

            stub = node
        }

    }
}