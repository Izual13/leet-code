package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

@Suppress("ClassName")
class `Copy List with Random Pointer` {


    private class Node(var `val`: Int) {
        var next: Node? = null
        var random: Node? = null
    }


    @Test
    fun test1() {
        val n1 = Node(7)
        val n2 = Node(13)
        val n3 = Node(11)
        val n4 = Node(10)
        val n5 = Node(1)

        n1.next = n2

        n2.next = n3
        n2.random = n1

        n3.next = n4
        n3.random = n5

        n4.next = n5
        n4.random = n3

        n5.random = n1

        val actual = copyRandomList(n1)

        Assertions.assertEquals(n1.`val`, actual!!.`val`)
        Assertions.assertEquals(n2.`val`, actual.next!!.`val`)
        Assertions.assertEquals(n3.`val`, actual.next!!.next!!.`val`)
        Assertions.assertEquals(n4.`val`, actual.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(n5.`val`, actual.next!!.next!!.next!!.next!!.`val`)

        printList(n1)
        printList(actual)
    }

    private fun printList(node: Node?) {
        println("start ->")
        var root = node
        while (root != null) {
            println("${root.`val`} (${root.hashCode()} ${root.next?.hashCode()} ${root.random?.hashCode()})")
            root = root.next
        }
    }

    private fun copyRandomList(node: Node?): Node? {
        if (node == null) {
            return node
        }

        var cur = node

        while (cur != null) {
            val new = Node(cur.`val`)
            val tmp = cur.next
            cur.next = new
            new.next = tmp
            cur = tmp
        }

        cur = node
        while (cur != null) {
            val tmp = cur.random
            cur.next!!.random = tmp?.next
            cur = cur.next!!.next
        }

        val result = node.next
        cur = node.next
        var old = node
        while (cur?.next?.next != null) {
            val tmp = cur.next!!.next
            old!!.next = old.next!!.next
            old = old.next
            cur.next = tmp
            cur = tmp
        }

        old?.next = null

        return result
    }
}