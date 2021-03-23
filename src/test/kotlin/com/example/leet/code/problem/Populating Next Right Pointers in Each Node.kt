package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Populating Next Right Pointers in Each Node` {

    class Node(var `val`: Int) {
        var left: Node? = null
        var right: Node? = null
        var next: Node? = null
    }

    @Test
    fun test1() {
        val root = Node(1)
        val n1 = Node(2)
        val n2 = Node(3)

        root.left = n1
        root.right = n2

        n1.left = Node(4)
        n1.right = Node(5)

        n2.left = Node(6)
        n2.right = Node(7)

        val tree = connect(root)
        Assertions.assertEquals(tree?.`val`, 1)
        Assertions.assertEquals(n1.next!!.`val`, 3)
        Assertions.assertNull(n2.next)
        Assertions.assertEquals(n1.left!!.next!!.`val`, 5)
        Assertions.assertEquals(n1.right!!.next!!.`val`, 6)
        Assertions.assertEquals(n2.left!!.next!!.`val`, 7)
        Assertions.assertNull(n2.right!!.next)
    }

    @Test
    fun test2() {
        Assertions.assertNull(connect(null))
    }

    private fun connect(root: Node?): Node? {
        if (root == null) {
            return root
        }

        val list = LinkedList<Node?>()
        list.push(root)

        while (list.isNotEmpty()) {
            val lastIndex = list.lastIndex
            for (i in 0..lastIndex) {
                val last = list.poll()!!
                if (i <= lastIndex - 1) {
                    last.next = list.first
                }

                if (last.left != null) list.addLast(last.left)
                if (last.right != null) list.addLast(last.right)
            }
        }

        return root
    }
}
