package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max


@Suppress("ClassName")
class `Longest Increasing Subsequence` {

    @Test
    fun test1() {
        Assertions.assertEquals(4, lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(4, lengthOfLIS(intArrayOf(0, 1, 0, 3, 2, 3)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(6, lengthOfLIS(intArrayOf(1, 3, 6, 7, 9, 4, 10, 5, 6)))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(1, lengthOfLIS(intArrayOf(7, 7, 7, 7, 7, 7, 7)))
    }


    private fun lengthOfLIS(nums: IntArray): Int {
        val cache = IntArray(nums.size) { 1 }
        var result = 1

        for (i in 0..nums.lastIndex) {
            for (j in 0 until i) {
                if (nums[i] > nums[j]) {
                    cache[i] = max(cache[i], cache[j] + 1)
                    result = max(result, cache[i])
                }
            }
        }

        return result
    }
}