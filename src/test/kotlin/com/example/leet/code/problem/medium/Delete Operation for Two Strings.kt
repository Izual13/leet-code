package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Delete Operation for Two Strings` {

    @Test
    fun test1() {
        Assertions.assertEquals(2, minDistance("sea", "eat"))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(4, minDistance("leetcode", "etco"))
    }


    private fun minDistance(text1: String, text2: String): Int {
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

        val last = cache.last().last()
        return (text1.length - last) + (text2.length - last)
    }
}