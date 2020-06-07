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
        var result = nums.first()

        for (i in 1 until nums.size) {
            nums[i] = Math.max(nums[i], nums[i - 1] + nums[i])

            if (nums[i] > result) {
                result = nums[i]
            }
        }

        return result
    }
}