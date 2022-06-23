package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Find All Anagrams in a String` {

    @Test
    fun test1() {
        Assertions.assertEquals(listOf(0, 6), findAnagrams("cbaebabacd", "abc"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(listOf(0, 1, 2), findAnagrams("abab", "ab"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(listOf(1), findAnagrams("baa", "aa"))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(listOf(1, 3, 6, 7), findAnagrams("acdcaeccde", "c"))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(listOf(3, 4, 6), findAnagrams("abaacbabc", "abc"))
    }


    private fun findAnagrams(s: String, p: String): List<Int> {
        val result = ArrayList<Int>()
        val map = IntArray(26)

        for (c in p) {
            map[c - 'a']++
        }

        var left = 0
        var right = 0
        var count = p.length

        while (right < s.length) {
            if (map[s[right++] - 'a']-- >= 1) {
                count--
            }

            if (count == 0) {
                result.add(left)
            }

            if (right - left == p.length && map[s[left++] - 'a']++ >= 0) {
                count++
            }
        }

        return result
    }
}