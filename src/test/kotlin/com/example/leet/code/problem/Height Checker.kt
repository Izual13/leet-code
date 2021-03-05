package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Height Checker` {

    @Test
    fun test1() {
        Assertions.assertEquals(5, heightChecker(intArrayOf(5, 1, 2, 3, 4)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(0, heightChecker(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(3, heightChecker(intArrayOf(1, 1, 4, 2, 1, 3)))
    }

    private fun heightChecker(heights: IntArray): Int {
        var count = 0

        val clone = heights.clone()
        clone.sort()

        for (i in 0..heights.lastIndex) {
            if (clone[i] != heights[i]) {
                count++
            }
        }

        return count
    }
}