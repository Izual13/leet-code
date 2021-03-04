package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Move Zeroes` {

    @Test
    fun test1() {
        val nums = intArrayOf(0, 1, 0, 3, 12)
        moveZeroes(nums)
        Assertions.assertArrayEquals(intArrayOf(1, 3, 12, 0, 0), nums)
    }

    private fun moveZeroes(nums: IntArray): Unit {
        var index = 0
        for (num in nums) {
            if (num != 0) {
                nums[index++] = num
            }
        }

        for (i in index..nums.lastIndex) {
            nums[index++] = 0
        }
    }
}