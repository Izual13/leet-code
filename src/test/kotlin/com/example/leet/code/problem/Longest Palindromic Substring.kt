package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Longest Palindromic Substring` {

    @Test
    fun test1() {
        Assertions.assertEquals(longestPalindrome("babad"), "bab")
    }

    @Test
    fun test2() {
        Assertions.assertEquals(longestPalindrome("cbbd"), "bb")
    }

    fun longestPalindrome(s: String): String {
        var longStr = ""

        for (i in s.indices) {
            val oddStr = longestPalindrome(s, i, i);
            val evenStr = longestPalindrome(s, i, i + 1);
            println(oddStr)
            println(evenStr)

            if (oddStr.length > longStr.length) {
                longStr = oddStr
            }
            if (evenStr.length > longStr.length) {
                longStr = evenStr
            }
        }

        return longStr;
    }

    private fun longestPalindrome(s: String, left: Int, right: Int): String {
        var l = left
        var r = right
        while (l >= 0 && r < s.length && s[l] == s[r]) {
            l--;
            r++;
        }

        return s.substring(l + 1, r)
    }
}
