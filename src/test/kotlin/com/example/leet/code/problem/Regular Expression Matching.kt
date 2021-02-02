package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Regular Expression Matching` {


    @Test
    fun test1() {
        Assertions.assertEquals(true, isMatch("aab", "c*a*b"))
    }


    @Test
    fun test2() {
        Assertions.assertEquals(true, isMatch("aab", "..b"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(false, isMatch("mississippi", "mis*is*p*."))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(false, isMatch("aa", "a"))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(true, isMatch("aa", "a*"))
    }

    @Test
    fun test6() {
        Assertions.assertEquals(false, isMatch("bbb", "a*"))
    }

    @Test
    fun test7() {
        Assertions.assertEquals(true, isMatch("bbb", ".*"))
    }

    @Test
    fun test8() {
        Assertions.assertEquals(true, isMatch("a", "ab*"))
    }

    @Test
    fun test9() {
        Assertions.assertEquals(true, isMatch("", "a*"))
    }

    @Test
    fun test10() {
        Assertions.assertEquals(true, isMatch("", "a*a*"))
    }


    private fun isMatch(s: String, p: String): Boolean {
        if (p.isBlank() && s.isBlank()) {
            return true
        } else if (s.isNotBlank() && p.isBlank()) {
            return false
        } else if (s.isBlank() && p.length > 1 && p[1] == '*') {
            return isMatch(s, p.substring(2))
        } else if (s.isBlank() && p.isNotBlank()) {
            return false
        }

        var result = true

        val actual = s[0]
        val expected = p[0]

        if (p.length > 1 && p[1] == '*') {
            var tmp = false
            tmp = tmp || isMatch(s, p.substring(2))

            for (i in 1..s.length) {
                if (s[i - 1] == expected || expected == '.') {
                    tmp = tmp || isMatch(s.substring(i), p.substring(2))
                } else {
                    break
                }
            }
            result = result && tmp
        } else if (actual == expected || expected == '.') {
            result = result && isMatch(s.substring(1), p.substring(1))
        } else {
            result = false
        }

        return result
    }
}