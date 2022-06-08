package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Product of Array Except Self` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(intArrayOf(24, 12, 8, 6), productExceptSelf(intArrayOf(1, 2, 3, 4)))
    }

    private fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)
        result[0] = 1
        var tmp = 1
        for (i in 1..nums.lastIndex) {
            tmp *= nums[i - 1]
            result[i] = tmp
        }

        tmp = 1
        for (i in nums.lastIndex - 1 downTo 0) {
            tmp *= nums[i + 1]
            result[i] = result[i] * tmp
        }

        return result
    }
}