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

    @Test
    fun test11() {
        Assertions.assertEquals(true, isMatch("mississippi", "mis*is*ip*."))
    }

    @Test
    fun test12() {
        Assertions.assertEquals(false, isMatch("ab", ".*c"))
    }

    @Test
    fun test13() {
        Assertions.assertEquals(true, isMatch("", ""))
    }

    @Test
    fun test14() {
        Assertions.assertEquals(false, isMatch("a", ""))
    }

    @Test
    fun test15() {
        Assertions.assertEquals(true, isMatch("aaa", "ab*a*c*a"))
    }


    private fun isMatch(s: String, p: String, sIndex: Int = 0, pIndex: Int = 0): Boolean {
        if (p.lastIndex == pIndex - 1 && s.lastIndex == sIndex - 1) {
            return true
        } else if (p.lastIndex == pIndex - 1 && s.lastIndex > sIndex - 1) {
            return false
        } else if (s.lastIndex == sIndex - 1 && p.lastIndex > pIndex && p[pIndex + 1] == '*') {
            return isMatch(s, p, sIndex, pIndex + 2)
        } else if (s.lastIndex == sIndex - 1 && p.lastIndex > pIndex - 1) {
            return false
        }

        var result = true

        val actual = s[sIndex]
        val expected = p[pIndex]

        if (p.lastIndex > pIndex && p[pIndex + 1] == '*') {
            var tmp = false
            tmp = tmp || isMatch(s, p, sIndex, pIndex + 2)

            for (i in sIndex + 1..s.length) {
                if (s[i - 1] == expected || expected == '.') {
                    tmp = tmp || isMatch(s, p, i, pIndex + 2)
                } else {
                    break
                }
            }
            result = result && tmp
        } else if (actual == expected || expected == '.') {
            result = result && isMatch(s, p, sIndex + 1, pIndex + 1)
        } else {
            result = false
        }

        return result
    }
}