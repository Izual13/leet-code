package com.example.leet.code.problem.list

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Palindrome Linked List` {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    @Test
    fun test1() {

        var head = ListNode(1)
        head.next = ListNode(2)
        head.next!!.next = ListNode(2)
        head.next!!.next?.next = ListNode(1)


        Assertions.assertEquals(isPalindrome(head), true)
    }

    @Test
    fun test2() {

        var head = ListNode(1)
        head.next = ListNode(2)
        head.next!!.next = ListNode(1)


        Assertions.assertEquals(isPalindrome(head), true)
    }


    private fun isPalindrome(head: ListNode?): Boolean {
        if (head?.next == null) {
            return true
        }

        var lenght = 0
        var tmp = head
        while (tmp != null) {
            lenght++
            tmp = tmp.next
        }

        var previous: ListNode? = null
        var current: ListNode? = head
        for (i in 0 until lenght / 2) {
            val next = current!!.next
            current.next = previous

            previous = current

            current = next
        }

        if (lenght % 2 != 0) {
            current = current!!.next
        }

        return compare(previous, current)
    }

    private fun compare(first: ListNode?, second: ListNode?): Boolean {
        var f = first
        var s = second


        while (f != null && s != null) {
            if (f.`val` != s.`val`) {
                return false
            }
            f = f.next
            s = s.next
        }
        return true
    }

    private fun swap(head: ListNode?) {
        val next = head?.next
        if (next != null) {
            next.next = head
        }
    }

}