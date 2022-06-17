package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Sort List` {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    @Test
    fun test1() {
//        4,2,1,3
        val l1 = ListNode(1)
        val l2 = ListNode(2)
        val l3 = ListNode(3)
        val l4 = ListNode(4)

        l4.next = l2
        l2.next = l1
        l1.next = l3


        val root = sortList(l4)
        Assertions.assertEquals(1, root!!.`val`)
        Assertions.assertEquals(2, root.next!!.`val`)
        Assertions.assertEquals(3, root.next!!.next!!.`val`)
        Assertions.assertEquals(4, root.next!!.next!!.next!!.`val`)
    }


    private fun sortList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        val l2 = mid(head)

        val s1 = sortList(head)
        val s2 = sortList(l2)

        return merge(s1, s2)
    }

    private fun mid(first: ListNode?): ListNode? {
        if (first?.next == null) {
            return first
        }

        var prev = first
        var tmp = first.next
        while (tmp?.next != null) {
            prev = prev!!.next
            tmp = tmp.next?.next
        }

        val result = prev?.next
        prev?.next = null

        return result
    }


    private fun merge(l1: ListNode?, l2: ListNode?): ListNode? {
        val root = ListNode(0)
        var tmp = root

        var ll1 = l1
        var ll2 = l2

        while (ll1 != null && ll2 != null) {
            if (ll1.`val` < ll2.`val`) {
                tmp.next = ll1
                tmp = ll1
                ll1 = ll1.next
            } else {
                tmp.next = ll2
                tmp = ll2
                ll2 = ll2.next
            }
        }

        tmp.next = ll1 ?: ll2

        return root.next
    }
}