package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Reverse Linked List` {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    @Test
    fun test1() {
        val root = ListNode(1)
        val l1 = ListNode(2)
        val l2 = ListNode(3)
        val l3 = ListNode(4)
        val l4 = ListNode(5)


        root.next = l1
        l1.next = l2
        l2.next = l3
        l3.next = l4

        val newRoot = reverseList(root)

        Assertions.assertEquals(5, newRoot!!.`val`)
        Assertions.assertEquals(4, newRoot.next!!.`val`)
        Assertions.assertEquals(3, newRoot.next!!.next!!.`val`)
        Assertions.assertEquals(2, newRoot.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(1, newRoot.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertNull(newRoot.next!!.next!!.next!!.next!!)
    }


    private fun reverseList(head: ListNode?): ListNode? {
        var current = head
        var previous: ListNode? = null

        while (current != null) {
            val tmp=current.next
            current.next = previous
            previous = current
            current = tmp
        }
        return previous
    }
}