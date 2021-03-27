package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Find Peak Element` {


    @Test
    fun test1() {
        Assertions.assertEquals(2, findPeakElement(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(1, findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(1, findPeakElement(intArrayOf(1, 2)))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(0, findPeakElement(intArrayOf(2, 1)))
    }

    private fun findPeakElement(nums: IntArray): Int {
        if (nums.size < 2) {
            return nums.lastIndex
        }

        for (i in 1 until nums.lastIndex) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i
            }
        }

        var maxIndex = 0
        for (i in 1..nums.lastIndex) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i
            }
        }
        return maxIndex
    }
}