package com.example.leet.code.problem.list

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Rotate List` {

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

        val newRoot = rotateRight(root, 2)
        Assertions.assertEquals(4, newRoot?.`val`)
        Assertions.assertEquals(5, newRoot?.next?.`val`)
        Assertions.assertEquals(1, newRoot?.next?.next?.`val`)
        Assertions.assertEquals(2, newRoot?.next?.next?.next?.`val`)
        Assertions.assertEquals(3, newRoot?.next?.next?.next?.next?.`val`)
        Assertions.assertNull(newRoot?.next?.next?.next?.next?.next?.`val`)
    }

    @Test
    fun test2() {
        val root = ListNode(0)
        val l1 = ListNode(1)
        val l2 = ListNode(2)


        root.next = l1
        l1.next = l2

        val newRoot = rotateRight(root, 4)
        Assertions.assertEquals(2, newRoot?.`val`)
        Assertions.assertEquals(0, newRoot?.next?.`val`)
        Assertions.assertEquals(1, newRoot?.next?.next?.`val`)
        Assertions.assertNull(newRoot?.next?.next?.next?.`val`)
    }


    @Test
    fun test3() {
        val root = ListNode(0)
        val l1 = ListNode(1)
        val l2 = ListNode(2)


        root.next = l1
        l1.next = l2

        val newRoot = rotateRight(root, 6)
        Assertions.assertEquals(0, newRoot?.`val`)
        Assertions.assertEquals(1, newRoot?.next?.`val`)
        Assertions.assertEquals(2, newRoot?.next?.next?.`val`)
        Assertions.assertNull(newRoot?.next?.next?.next?.`val`)
    }

    private fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if (head?.next == null) {
            return head
        }

        var count = 0

        var root = head
        while (root != null) {
            root = root.next
            count++
        }

        val index = count - (k % count)

        var lastElement = head
        for (i in 1 until index) {
            lastElement = lastElement?.next
        }

        if (lastElement?.next == null) {
            return head
        }

        val newHead = lastElement.next
        var tmp = newHead
        lastElement.next = null

        for (i in index until count - 1) {
            tmp = tmp?.next
        }

        tmp?.next = head

        return newHead
    }
}