package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Odd Even Linked List` {

    @Test
    fun test1() {
        val l1 = ListNode(1)
        val l2 = ListNode(2)
        val l3 = ListNode(3)
        val l4 = ListNode(4)
        val l5 = ListNode(5)


        l1.next = l2
        l2.next = l3
        l3.next = l4
        l4.next = l5


        val result = oddEvenList(l1)
        Assertions.assertEquals(1, result!!.`val`)
        Assertions.assertEquals(3, result.next!!.`val`)
        Assertions.assertEquals(5, result.next!!.next!!.`val`)
        Assertions.assertEquals(2, result.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(4, result.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next!!.next!!.next)
    }

    @Test
    fun test2() {
        val l1 = ListNode(1)
        val l2 = ListNode(2)
        val l3 = ListNode(3)
        val l4 = ListNode(4)


        l1.next = l2
        l2.next = l3
        l3.next = l4


        val result = oddEvenList(l1)
        Assertions.assertEquals(1, result!!.`val`)
        Assertions.assertEquals(3, result.next!!.`val`)
        Assertions.assertEquals(2, result.next!!.next!!.`val`)
        Assertions.assertEquals(4, result.next!!.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next!!.next)
    }


    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    private fun oddEvenList(head: ListNode?): ListNode? {

        val evenHead = head?.next

        if (evenHead == null) {
            return head
        }

        var odd = head
        var even = head.next

        var cur = even?.next
        var count = 3
        while (cur != null) {
            if (count.and(1) == 1) {
                odd!!.next = cur
                odd = odd.next
            } else {
                even!!.next = cur
                even = even.next
            }

            cur = cur.next
            count++
        }

        odd!!.next = evenHead
        even!!.next = null

        return head
    }
}