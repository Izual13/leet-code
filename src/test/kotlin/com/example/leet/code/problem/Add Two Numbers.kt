package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Add Two Numbers` {

    @Test
    fun test1() {
        val l1 = ListNode(2)
        val l2 = ListNode(4)
        val l3 = ListNode(3)

        l1.next = l2
        l2.next = l3

        val l4 = ListNode(5)
        val l5 = ListNode(6)
        val l6 = ListNode(4)

        l4.next = l5
        l5.next = l6


        val result = addTwoNumbers(l1, l4)
        Assertions.assertEquals(7, result!!.`val`)
        Assertions.assertEquals(0, result.next!!.`val`)
        Assertions.assertEquals(8, result.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next)
    }

    @Test
    fun test2() {
        val l1 = ListNode(2)
        val l2 = ListNode(4)
        val l3 = ListNode(3)

        l1.next = l2
        l2.next = l3

        val l4 = ListNode(5)

        val result = addTwoNumbers(l1, l4)
        Assertions.assertEquals(7, result!!.`val`)
        Assertions.assertEquals(4, result.next!!.`val`)
        Assertions.assertEquals(3, result.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next)
    }

    @Test
    fun test3() {
        val l0 = ListNode(5)

        val l1 = ListNode(2)
        val l2 = ListNode(4)
        val l3 = ListNode(3)

        l1.next = l2
        l2.next = l3

        val result = addTwoNumbers(l0, l1)
        Assertions.assertEquals(7, result!!.`val`)
        Assertions.assertEquals(4, result.next!!.`val`)
        Assertions.assertEquals(3, result.next!!.next!!.`val`)
        Assertions.assertNull(result.next!!.next!!.next)
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null) {
            return l2
        } else if (l2 == null) {
            return l1
        }

        var c1 = l1
        var c2 = l2
        var resultList = ListNode(0)
        resultList.next = l1

        var tmp = 0
        while (c1 != null || c2 != null) {
            tmp += (c1?.`val` ?: 0) + (c2?.`val` ?: 0)


            if (resultList.next == null) {
                resultList.next = ListNode(tmp % 10)
            } else {
                resultList.next!!.`val` = tmp % 10
            }
            tmp /= 10
            resultList = resultList.next!!
            if (c1 != null) {
                c1 = c1.next
            }
            if (c2 != null) {
                c2 = c2.next
            }
        }

        if (tmp != 0) {
            resultList.next = ListNode(tmp)
        }

        return l1
    }
}