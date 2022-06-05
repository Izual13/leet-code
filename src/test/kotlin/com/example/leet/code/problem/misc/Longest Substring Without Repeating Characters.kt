package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Longest Substring Without Repeating Characters` {

    @Test
    fun test1() {
        Assertions.assertEquals(2, lengthOfLongestSubstring("aab"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(3, lengthOfLongestSubstring("pwwkew"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(3, lengthOfLongestSubstring("dvdf"))
    }

    private fun lengthOfLongestSubstring(s: String): Int {
        val map = HashMap<Char, Int>()
        var result = 0

        var start = 0
        for (i in s.indices) {
            if (map.containsKey(s[i])) {
                start = max(start, map[s[i]]!!)
            }
            result = max(result, i - start + 1)
            map[s[i]] = i + 1
        }

        return result
    }
}
