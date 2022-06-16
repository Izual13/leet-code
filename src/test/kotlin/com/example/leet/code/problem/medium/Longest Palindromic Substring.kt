package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
/** duplicate in [com.example.leet.code.problem.misc.Longest Palindromic Substring] */
class `Longest Palindromic Substring` {

    @Test
    fun test1() {
        Assertions.assertEquals("bab", longestPalindrome("babad"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals("bb", longestPalindrome("cbbd"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals("a", longestPalindrome("a"))
    }


    private fun longestPalindrome(s: String): String {
        var result = ""
        var length = -1
        for (start in s.indices) {
            var tmp = countPalindromic(s, start, start)
            if (length < tmp * 2) {
                length = tmp * 2
                result = s.substring(start - tmp, start + tmp+1)
            }

            tmp = countPalindromic(s, start, start + 1)
            if (length < tmp * 2 + 1) {
                length = tmp * 2 + 1
                result = s.substring(start - tmp, start + tmp + 2)
            }
        }

        return result
    }

    private fun countPalindromic(s: String, a: Int, b: Int): Int {
        var start = a
        var end = b
        var result = 0

        while (start >= 0 && end < s.length && s[start] == s[end]) {
            start--
            end++
            result++
        }

        return result - 1
    }
}