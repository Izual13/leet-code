package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Remove Duplicates from Sorted List` {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }


    @Test
    fun test1() {
        //1->1->2->3->3
        val root = ListNode(1)
        root.next = ListNode(1)
        root.next!!.next = ListNode(2)
        root.next!!.next!!.next = ListNode(3)
        root.next!!.next!!.next!!.next = ListNode(3)


        val actual = deleteDuplicates(root)

        Assertions.assertEquals(1, actual!!.`val`)
        Assertions.assertEquals(2, actual.next!!.`val`)
        Assertions.assertEquals(3, actual.next!!.next!!.`val`)
    }

    @Test
    fun test2() {
        val root = ListNode(1)
        val actual = deleteDuplicates(root)
        Assertions.assertEquals(1, actual!!.`val`)
    }

    private fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        var previous = head
        var tmp = head
        while (tmp != null) {
            if (previous?.`val` != tmp.`val`) {
                previous!!.next = tmp
                previous = tmp
            }
            tmp = tmp.next
        }

        previous!!.next = null

        return head
    }
}