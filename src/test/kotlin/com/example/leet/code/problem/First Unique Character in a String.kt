package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `First Unique Character in a String` {

    @Test
    fun test1() {
        Assertions.assertEquals(0, firstUniqChar("leetcode"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(2, firstUniqChar("loveleetcode"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(8, firstUniqChar("dddccdbba"))
    }


    private fun firstUniqChar(s: String): Int {
        val map = LinkedHashMap<Char, Int>()
        for (c in s) {
            val count = map.computeIfAbsent(c) { 0 }
            map[c] = count + 1
        }

        for ((index, c) in s.withIndex()) {
            if (map[c] == 1) {
                return index
            }
        }

        return -1
    }
}