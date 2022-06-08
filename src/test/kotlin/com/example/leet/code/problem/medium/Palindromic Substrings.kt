package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Palindromic Substrings` {

    @Test
    fun test1() {
        Assertions.assertEquals(6, countSubstrings("aaa"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(3, countSubstrings("abc"))
    }


    private fun countSubstrings(s: String): Int {
        val last = s.lastIndex
        var result = 0
        var start = 0
        while (start <= last) {
            result += countPalindromic(s, start, start)
            result += countPalindromic(s, start, start + 1)
            start++
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

        return result
    }
}