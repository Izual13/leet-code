package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

@Suppress("ClassName")
class `Remove All Adjacent Duplicates in String II` {

    @Test
    fun test1() {
        Assertions.assertEquals("aa", removeDuplicates("deeedbbcccbdaa", 3))
    }


    private fun removeDuplicates(s: String, k: Int): String {
        val q = LinkedList<Pair<Char, AtomicInteger>>()

        for (i in s) {
            val first = q.peek()
            if (first != null && first.first == i) {
                if (first.second.incrementAndGet() == k) {
                    q.pop()
                }
            } else {
                q.push(i to AtomicInteger(1))
            }
        }


        val result = StringBuilder()
        while (q.isNotEmpty()) {
            val last = q.pollLast()
            result.append(last.first.toString().repeat(last.second.get()))
        }
        return result.toString()
    }

}
