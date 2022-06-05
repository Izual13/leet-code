package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Maximum Subarray` {


    @Test
    fun test1() {
        Assertions.assertEquals(6, maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }

    private fun maxSubArray(nums: IntArray): Int {
        var result = nums.first()

        for (i in 1 until nums.size) {
            nums[i] = max(nums[i], nums[i - 1] + nums[i])

            if (nums[i] > result) {
                result = nums[i]
            }
        }

        return result
    }
}