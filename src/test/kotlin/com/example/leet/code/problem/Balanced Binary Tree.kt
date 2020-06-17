package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Balanced Binary Tree` {

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    @Test
    fun test1() {
        val tree = TreeNode(3)
        tree.left = TreeNode(9)
        tree.right = TreeNode(20)

        tree.right!!.left == TreeNode(15)
        tree.right!!.right == TreeNode(7)

        Assertions.assertEquals(true, isBalanced(tree))
    }

    @Test
    fun test2() {
        val tree = TreeNode(1)
        tree.left = TreeNode(2)
        tree.right = TreeNode(2)

        tree.left!!.left = TreeNode(3)
        tree.left!!.right = TreeNode(3)

        tree.left!!.left!!.left = TreeNode(4)
        tree.left!!.left!!.right = TreeNode(4)

        Assertions.assertEquals(false, isBalanced(tree))
    }

    @Test
    fun test3() {
        val tree = TreeNode(1)
        tree.right = TreeNode(3)
        tree.right!!.left = TreeNode(2)
        Assertions.assertEquals(false, isBalanced(tree))
    }

    @Test
    fun test4() {
        val tree = TreeNode(1)
        tree.left = TreeNode(2)
        tree.right = TreeNode(2)

        tree.left!!.left = TreeNode(3)
        tree.left!!.right = TreeNode(3)

        tree.right!!.left = TreeNode(3)
        tree.right!!.right = TreeNode(3)

        tree.left!!.left!!.left = TreeNode(4)
        tree.left!!.left!!.right = TreeNode(4)

        tree.left!!.right!!.left = TreeNode(4)
        tree.left!!.right!!.right = TreeNode(4)

        tree.right!!.left!!.left = TreeNode(4)
        tree.right!!.left!!.right = TreeNode(4)

        tree.left!!.left!!.left!!.left = TreeNode(5)
        tree.left!!.left!!.right!!.right = TreeNode(5)


        Assertions.assertEquals(true, isBalanced(tree))
    }

    private fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        val l = LinkedList<Pair<Int, TreeNode?>>()
        l.push(0 to root)
        var maxl: Int? = null
        var minl: Int? = null

        while (l.isNotEmpty()) {
            val pop = l.pop()

            if (pop.second == null) {

                if (minl == null || maxl == null) {
                    minl = pop.first
                    maxl = pop.first

                } else {
                    maxl = Math.max(maxl, pop.first)
                    minl = Math.min(minl, pop.first)
                    if (Math.abs(minl - maxl) >= 1) {
                        return false
                    }
                }



                continue
            }

            l.push(pop.first + 1 to pop.second!!.left)
            l.push(pop.first + 1 to pop.second!!.right)


        }

        return true
    }


}
