package com.example.leet.code.problem.list

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Intersection of Two Linked Lists` {

    @Test
    fun test1() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)

        val b1 = ListNode(3)
        val b2 = ListNode(4)
        val b3 = ListNode(5)


        val c1 = ListNode(6)
        val c2 = ListNode(7)
        val c3 = ListNode(8)

        a1.next = a2
        a2.next = c1

        b1.next = b2
        b2.next = b3
        b3.next = c1

        c1.next = c2
        c2.next = c3


        val result = getIntersectionNode(a1, b1)
        Assertions.assertEquals(6, result!!.`val`)
        Assertions.assertEquals(7, result.next!!.`val`)
        Assertions.assertEquals(8, result.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next)
    }

    @Test
    fun test2() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)

        val b1 = ListNode(3)
        val b2 = ListNode(4)
        val b3 = ListNode(5)


        a1.next = a2

        b1.next = b2
        b2.next = b3

        val result = getIntersectionNode(a1, b1)
        Assertions.assertNull(result)
    }


    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    private fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        if (headA == null || headB == null) {
            return null
        }

        var p1 = headA
        var p2 = headB

        while (p1 != p2) {
            p1 = if(p1==null) headB else p1.next
            p2 = if(p2==null) headA else p2.next
        }

        return p1
    }
}