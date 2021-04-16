package com.example.leet.code.problem.list

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Partition List` {

    @Test
    fun test1() {
        val l1 = ListNode(1)
        val l2 = ListNode(4)
        val l3 = ListNode(3)
        val l4 = ListNode(2)
        val l5 = ListNode(5)
        val l6 = ListNode(2)

        l1.next = l2
        l2.next = l3
        l3.next = l4
        l4.next = l5
        l5.next = l6

        val result = partition(l1, 3)
        Assertions.assertEquals(1, result!!.`val`)
        Assertions.assertEquals(2, result.next!!.`val`)
        Assertions.assertEquals(2, result.next!!.next!!.`val`)
        Assertions.assertEquals(4, result.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(3, result.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(5, result.next!!.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next!!.next!!.next!!.next)
    }

    @Test
    fun test2() {
        val l1 = ListNode(1)
        val l2 = ListNode(4)
        val l3 = ListNode(3)
        val l4 = ListNode(0)
        val l5 = ListNode(2)
        val l6 = ListNode(5)
        val l7 = ListNode(2)

        l1.next = l2
        l2.next = l3
        l3.next = l4
        l4.next = l5
        l5.next = l6
        l6.next = l7

        val result = partition(l1, 3)
        Assertions.assertEquals(1, result!!.`val`)
        Assertions.assertEquals(0, result.next!!.`val`)
        Assertions.assertEquals(2, result.next!!.next!!.`val`)
        Assertions.assertEquals(2, result.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(4, result.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(3, result.next!!.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertEquals(5, result.next!!.next!!.next!!.next!!.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next!!.next!!.next!!.next!!.next)
    }

    @Test
    fun test3() {
        val l1 = ListNode(1)
        val l2 = ListNode(1)

        l1.next = l2

        val result = partition(l1, 3)
        Assertions.assertEquals(1, result!!.`val`)
        Assertions.assertEquals(1, result.next!!.`val`)
        Assertions.assertNull(result.next!!.next)
    }


    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    private fun partition(head: ListNode?, x: Int): ListNode? {
        var list1Start: ListNode? = null
        var list1End: ListNode? = null

        var list2Start: ListNode? = null
        var list2End: ListNode? = null


        var previousCursor: ListNode? = null
        var cursor = head

        while (cursor != null) {
            val next = cursor.next
            if (cursor.`val` < x) {
                if (list1Start == null) {
                    list1Start = cursor
                    list1End = cursor
                } else {
                    list1End!!.next = cursor
                    list1End = cursor
                }

                if (previousCursor != null) {
                    previousCursor.next = cursor.next
                    previousCursor = list2End ?: list1End
                }
            } else {
                if (list2Start == null) {
                    list2Start = cursor
                    list2End = cursor
                } else {
                    list2End!!.next = cursor
                    list2End = cursor
                }
                previousCursor = cursor
            }

            cursor = next
        }

        if (list1End != null) {
            list1End.next = list2Start
        }

        return list1Start ?: list2Start
    }
}