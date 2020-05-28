package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Longest Substring Without Repeating Characters` {

    @Test
    fun test1() {
        Assertions.assertEquals(lengthOfLongestSubstring("aab"), 2)
    }

    private fun lengthOfLongestSubstring(s: String): Int {
        val set = LinkedHashSet<Int>()
        var max = 0
        s.chars().forEach {
            if (!set.add(it)) {
                val iterator = set.iterator()

                while (iterator.next() != it) {
                    iterator.remove()
                }
                iterator.remove()
                set.add(it)
            }
            max = kotlin.math.max(set.size, max)
        }

        return max
    }
}
