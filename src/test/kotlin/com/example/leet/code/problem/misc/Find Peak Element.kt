package com.example.leet.code.problem.misc

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
        Assertions.assertEquals(6, findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 7)))
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
        var l = 0
        var r = nums.lastIndex
        while (l < r) {
            val mid = (l + r) / 2
            if (nums[mid] > nums[mid + 1]) {
                r = mid
            } else {
                l = mid + 1
            }
        }
        return l
    }
}