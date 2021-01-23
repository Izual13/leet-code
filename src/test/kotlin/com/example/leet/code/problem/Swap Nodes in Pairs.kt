package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Swap Nodes in Pairs` {

    @Test
    fun test1() {
        val root = ListNode(1)
        val l2 = ListNode(2)
        val l3 = ListNode(3)
        val l4 = ListNode(4)
        root.next = l2
        l2.next = l3
        l3.next = l4

        val result = swapPairs(root)
        Assertions.assertEquals(2, result!!.`val`)
        Assertions.assertEquals(1, result.next!!.`val`)
        Assertions.assertEquals(4, result.next!!.next!!.`val`)
        Assertions.assertEquals(3, result.next!!.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next!!.next)
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    private fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val root = ListNode(-1)
        root.next = head
        var current: ListNode? = root


        while (current?.next?.next != null) {
            val p1 = current.next
            val p2 = current.next!!.next

            p1!!.next = p2!!.next
            p2.next = p1
            current.next = p2

            current = p1
        }

        return root.next
    }
}