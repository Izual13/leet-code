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
            var end = last+1
            while (start < end) {
                val ss = s.substring(start, end)
                if (isPalindrom(ss)) {
                    result += 1
                }
                end--
            }
            start++
        }

        return result
    }

    private fun isPalindrom(s: String): Boolean {
        var start = 0
        var end = s.length - 1

        while (start < end) {
            if (s[start++] != s[end--]) {
                return false
            }
        }

        return true
    }
}