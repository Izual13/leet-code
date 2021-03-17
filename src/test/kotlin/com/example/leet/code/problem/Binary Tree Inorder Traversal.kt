package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.collections.ArrayList

@Suppress("ClassName")
class `Binary Tree Inorder Traversal` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val tree = TreeNode(1)
        tree.right = TreeNode(2)

        tree.right!!.left = TreeNode(3)

        val levelOrder = inorderTraversal(tree)

        Assertions.assertEquals(3, levelOrder.size)
        Assertions.assertEquals(arrayListOf(1, 3, 2), levelOrder)
    }

    @Test
    fun test2() {
        val tree = TreeNode(1)
        tree.left = TreeNode(2)

        val levelOrder = inorderTraversal(tree)

        Assertions.assertEquals(2, levelOrder.size)
        Assertions.assertEquals(arrayListOf(2, 1), levelOrder)
    }

    @Test
    fun test3() {
        val tree = TreeNode(1)
        tree.right = TreeNode(2)

        val levelOrder = inorderTraversal(tree)

        Assertions.assertEquals(2, levelOrder.size)
        Assertions.assertEquals(arrayListOf(1, 2), levelOrder)
    }

    private fun inorderTraversal(root: TreeNode?): List<Int> {

        val linkedList = LinkedList<TreeNode>()
        val result = ArrayList<Int>()

        var p = root
        while (linkedList.isNotEmpty() || p != null) {
            while (p != null) {
                linkedList.push(p)
                p = p.left
            }

            val pop = linkedList.pop()
            result.add(pop.`val`)
            p = pop.right
        }

        return result
    }

}
