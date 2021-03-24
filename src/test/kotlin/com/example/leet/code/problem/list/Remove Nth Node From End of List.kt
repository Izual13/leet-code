package com.example.leet.code.problem.list

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Remove Nth Node From End of List` {

    private class ListNode(var `val`: Int) {
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


        val result = removeNthFromEnd(root, 2)
        Assertions.assertEquals(1, result!!.`val`)
        Assertions.assertEquals(2, result.next!!.`val`)
        Assertions.assertEquals(3, result.next!!.next!!.`val`)
        Assertions.assertEquals(5, result.next!!.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next!!.next)
    }

    @Test
    fun test2() {
        val root = ListNode(1)
        val l1 = ListNode(2)

        root.next = l1


        val result = removeNthFromEnd(root, 1)
        Assertions.assertEquals(1, result!!.`val`)
        Assertions.assertNull(result.next)
    }

    @Test
    fun test3() {
        val root = ListNode(1)

        val result = removeNthFromEnd(root, 1)
        Assertions.assertNull(result)
    }

    @Test
    fun test4() {
        val root = ListNode(1)
        val l1 = ListNode(2)
        root.next = l1

        val result = removeNthFromEnd(root, 2)
        Assertions.assertEquals(2, result!!.`val`)
        Assertions.assertNull(result.next)
    }


    private fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        if (head == null) {
            return null
        }

        if (n == 1 && head.next == null) {
            return null
        }

        var p1: ListNode = head
        var p2: ListNode = head


        for (i in 0 until n) {
            if (p2.next == null) {
                return p1.next
            }
            p2 = p2.next!!
        }

        while (p2.next != null) {
            p1 = p1.next!!
            p2 = p2.next!!
        }

        p1.next = p1.next!!.next

        return head
    }
}