package com.example.leet.code.problem.list

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Linked List Cycle` {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    @Test
    fun test1() {
        val root = ListNode(3)
        val l1 = ListNode(2)
        val l2 = ListNode(0)
        val l3 = ListNode(-4)


        root.next = l1
        l1.next = l2
        l2.next = l3
        l3.next = l1

        Assertions.assertEquals(true, hasCycle(root))
    }

    @Test
    fun test2() {
        val root = ListNode(3)
        val l1 = ListNode(2)
        val l2 = ListNode(0)
        val l3 = ListNode(-4)


        root.next = l1
        l1.next = l2
        l2.next = l3

        Assertions.assertEquals(false, hasCycle(root))
    }


    private fun hasCycle(head: ListNode?): Boolean {
        if (head?.next == null) {
            return false
        }

        var p1 = head
        var p2 = head.next

        while (p2 != null) {
            if (p1 == p2) {
                return true
            }
            p1 = p1?.next
            p2 = p2.next?.next
        }

        return false
    }
}