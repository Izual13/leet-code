package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Merge Two Sorted Lists` {


    private class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    @Test
    fun test1() {

        val root1 = ListNode(1)
        root1.next = ListNode(2)
        root1.next!!.next = ListNode(4)


        val root2 = ListNode(1)
        root2.next = ListNode(3)
        root2.next!!.next = ListNode(4)


        val lists = mergeTwoLists(root1, root2)
        Assertions.assertEquals(lists!!.`val`, 1)
        Assertions.assertEquals(lists.next!!.`val`, 1)
        Assertions.assertEquals(lists.next!!.next!!.`val`, 2)
        Assertions.assertEquals(lists.next!!.next!!.next!!.`val`, 3)
        Assertions.assertEquals(lists.next!!.next!!.next!!.next!!.`val`, 4)
        Assertions.assertEquals(lists.next!!.next!!.next!!.next!!.next!!.`val`, 4)
    }

    private fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var t1 = l1
        var t2 = l2
        val result = ListNode(0)
        var tmp = result
        while (t1 != null || t2 != null) {
            val v1 = t1?.`val`
            val v2 = t2?.`val`

            when {
                v1 == null -> {
                    tmp.next = ListNode(v2!!)
                    tmp = tmp.next!!
                    t2 = t2?.next
                }
                v2 == null -> {
                    tmp.next = ListNode(v1)
                    tmp = tmp.next!!
                    t1 = t1?.next
                }
                v1 <= v2 -> {
                    tmp.next = ListNode(v1)
                    tmp = tmp.next!!
                    t1 = t1?.next
                }
                else -> {
                    tmp.next = ListNode(v2)
                    tmp = tmp.next!!
                    t2 = t2?.next
                }
            }
        }

        return result.next
    }
}