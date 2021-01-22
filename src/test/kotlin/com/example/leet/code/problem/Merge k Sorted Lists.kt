package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Merge k Sorted Lists` {

    @Test
    fun test1() {
        val l1 = ListNode(1)
        val l2 = ListNode(4)
        val l3 = ListNode(5)

        l1.next = l2
        l2.next = l3

        val l4 = ListNode(1)
        val l5 = ListNode(3)
        val l6 = ListNode(4)

        l4.next = l5
        l5.next = l6

        val l7 = ListNode(2)
        val l8 = ListNode(6)

        l7.next = l8

        val result = mergeKLists(arrayOf(l1, l4, l7))
        Assertions.assertEquals(1, result!!.`val`)
        Assertions.assertEquals(1, result.next!!.`val`)
        Assertions.assertEquals(2, result.next!!.next!!.`val`)
        Assertions.assertEquals(3, result.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(4, result.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(4, result.next!!.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(5, result.next!!.next!!.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(6, result.next!!.next!!.next!!.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next!!.next!!.next!!.next!!.next!!.next)
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        if (lists.size == 0) {
            return null
        } else if (lists.size == 1) {
            return lists[0]
        }

        var result: ListNode? = lists[0]

        for (i in 1 until lists.size) {
            result = mergeLists(result, lists[i])
        }

        return result
    }

    fun mergeLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) {
            return l2
        } else if (l2 == null) {
            return l1
        }

        val root = ListNode(-1)
        var tmp: ListNode? = root

        var t1 = l1
        var t2 = l2

        while (t1 != null || t2 != null) {
            if (t1 == null) {
                tmp!!.next = ListNode(t2!!.`val`)
                t2 = t2.next
            } else if (t2 == null) {
                tmp!!.next = ListNode(t1.`val`)
                t1 = t1.next
            } else if (t1.`val` < t2.`val`) {
                tmp!!.next = ListNode(t1.`val`)
                t1 = t1.next
            } else {
                tmp!!.next = ListNode(t2.`val`)
                t2 = t2.next
            }

            tmp = tmp!!.next!!
        }
        return root.next
    }
}