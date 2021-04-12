package com.example.leet.code.problem.list

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Remove Linked List Elements` {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    @Test
    fun test1() {
        val root = ListNode(1)
        val l1 = ListNode(2)
        val l2 = ListNode(6)
        val l3 = ListNode(3)
        val l4 = ListNode(4)
        val l5 = ListNode(5)
        val l6 = ListNode(6)


        root.next = l1
        l1.next = l2
        l2.next = l3
        l3.next = l4
        l4.next = l5
        l5.next = l6

        val newRoot = removeElements(root, 6)

        Assertions.assertEquals(1, newRoot!!.`val`)
        Assertions.assertEquals(2, newRoot.next!!.`val`)
        Assertions.assertEquals(3, newRoot.next!!.next!!.`val`)
        Assertions.assertEquals(4, newRoot.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(5, newRoot.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertNull(newRoot.next!!.next!!.next!!.next!!.next)
    }

    @Test
    fun test2() {
        val root = ListNode(1)
        val l1 = ListNode(2)
        val l2 = ListNode(3)
        val l3 = ListNode(4)
        val l4 = ListNode(5)


        root.next = l1
        l1.next = l2
        l2.next = l3
        l3.next = l4

        val newRoot = removeElements(root, 1)

        Assertions.assertEquals(2, newRoot!!.`val`)
        Assertions.assertEquals(3, newRoot.next!!.`val`)
        Assertions.assertEquals(4, newRoot.next!!.next!!.`val`)
        Assertions.assertEquals(5, newRoot.next!!.next!!.next!!.`val`)
        Assertions.assertNull(newRoot.next!!.next!!.next!!.next)
    }

    @Test
    fun test3() {
        val root = ListNode(1)
        val l1 = ListNode(2)
        val l2 = ListNode(2)
        val l3 = ListNode(1)


        root.next = l1
        l1.next = l2
        l2.next = l3

        val newRoot = removeElements(root, 2)

        Assertions.assertEquals(1, newRoot!!.`val`)
        Assertions.assertEquals(1, newRoot.next!!.`val`)
        Assertions.assertNull(newRoot.next!!.next)
    }


    private fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        var tmpHead = head
        while (tmpHead?.`val` == `val`) {
            tmpHead = tmpHead.next
        }

        var previous = tmpHead
        var tmpNode = tmpHead?.next

        while (tmpNode != null) {
            if (tmpNode.`val` == `val`) {
                previous!!.next = tmpNode.next
                tmpNode = tmpNode.next
            }else{
                previous = tmpNode
                tmpNode = tmpNode.next
            }
        }

        return tmpHead
    }
}