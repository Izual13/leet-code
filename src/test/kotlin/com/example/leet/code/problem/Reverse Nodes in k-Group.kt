package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Reverse Nodes in k-Group` {

    @Test
    fun test1() {
        val root = ListNode(1)
        val l2 = ListNode(2)
        val l3 = ListNode(3)
        val l4 = ListNode(4)
        val l5 = ListNode(5)
        root.next = l2
        l2.next = l3
        l3.next = l4
        l4.next = l5

        val result = reverseKGroup(root, 3)
        Assertions.assertEquals(3, result!!.`val`)
        Assertions.assertEquals(2, result.next!!.`val`)
        Assertions.assertEquals(1, result.next!!.next!!.`val`)
        Assertions.assertEquals(4, result.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(5, result.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next!!.next!!.next)
    }

    @Test
    fun test2() {
        val root = ListNode(1)
        val l2 = ListNode(2)
        val l3 = ListNode(3)
        val l4 = ListNode(4)
        val l5 = ListNode(5)
        root.next = l2
        l2.next = l3
        l3.next = l4
        l4.next = l5

        val result = reverseKGroup(root, 2)
        Assertions.assertEquals(2, result!!.`val`)
        Assertions.assertEquals(1, result.next!!.`val`)
        Assertions.assertEquals(4, result.next!!.next!!.`val`)
        Assertions.assertEquals(3, result.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(5, result.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next!!.next!!.next)
    }

    data class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    private fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) {
            return head
        }

        val root = ListNode(-1)
        root.next = head
        var cur: ListNode? = head
        var prev: ListNode? = root


        while (cur != null) {
            val startGroup: ListNode = cur
            for (i in 0 until k) {
                if (cur == null) {
                    return root.next
                }
                cur = cur.next
            }

            val lastNode = reverseGroup(startGroup, k)
            prev!!.next = lastNode
            startGroup.next = cur
            prev = startGroup

        }

        return root.next
    }

    private fun reverseGroup(head: ListNode?, k: Int): ListNode? {
        var prev: ListNode? = null
        var tmp: ListNode? = head
        var next: ListNode?

        for (i in 0 until k) {
            next = tmp!!.next
            tmp.next = prev
            prev = tmp
            tmp = next
        }

        return prev
    }
}