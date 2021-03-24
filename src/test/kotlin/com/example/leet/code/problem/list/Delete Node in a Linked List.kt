package com.example.leet.code.problem.list

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Delete Node in a Linked List` {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    @Test
    fun test1() {
        val root = ListNode(4)
        val l1 = ListNode(5)
        val l2 = ListNode(1)
        val l3 = ListNode(9)


        root.next = l1
        l1.next = l2
        l2.next = l3

        deleteNode(l1)

        Assertions.assertEquals(4, root.`val`)
        Assertions.assertEquals(1, root.next!!.`val`)
        Assertions.assertEquals(9, root.next!!.next!!.`val`)
        Assertions.assertNull(root.next!!.next!!.next)
    }


    private fun deleteNode(node: ListNode?) {
        node!!.`val` = node.next!!.`val`
        node.next = node.next!!.next
    }
}