package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Longest Common Subsequence` {

    @Test
    fun test1() {
        Assertions.assertEquals(3, longestCommonSubsequence("abcde", "ace"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(3, longestCommonSubsequence("abc", "abc"))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(0, longestCommonSubsequence("abc", "def"))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(1, longestCommonSubsequence("bl", "yby"))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(5, longestCommonSubsequence("abcba", "abcbcba"))
    }

    private fun longestCommonSubsequence(text1: String, text2: String): Int {
        val cache: Array<IntArray> = Array(text1.length) { IntArray(text2.length) }

        for (i in text1.indices) {
            for (j in text2.indices) {
                if (text1[i] == text2[j]) {
                    cache[i][j] = if (j == 0 || i == 0) 1 else cache[i - 1][j - 1] + 1
                } else {
                    cache[i][j] = max(if (j == 0) 0 else cache[i][j - 1], if (i == 0) 0 else cache[i - 1][j])
                }
            }
        }

        return cache.last().last()
    }
}