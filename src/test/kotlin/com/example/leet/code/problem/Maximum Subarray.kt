package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Maximum Subarray` {


    @Test
    fun test1() {
        Assertions.assertEquals(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)), 6)
    }

    private fun maxSubArray(nums: IntArray): Int {
        if (nums.size == 1) {
            return nums.first()
        }
        var maxValue = nums.first()
        var result = maxValue

        for (i in 1 until nums.size) {
            maxValue = Math.max(nums[i], maxValue + nums[i])

            if (maxValue > result) {
                result = maxValue
            }

        }

        return result
    }
}