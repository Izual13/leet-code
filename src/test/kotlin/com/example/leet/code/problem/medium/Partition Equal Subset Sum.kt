package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Partition Equal Subset Sum` {

    @Test
    fun test1() {
        Assertions.assertEquals(true, canPartition(intArrayOf(1, 5, 11, 5)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(false, canPartition(intArrayOf(1, 2, 3, 5)))
    }


    private fun canPartition(nums: IntArray): Boolean {
        val sum = nums.sum()
        if (sum.and(1) == 1) {
            return false
        }

        val half = sum / 2
        nums.sort()

        return find(nums, half)
    }

    private fun find(nums: IntArray, sum: Int, c: Int = 0): Boolean {
        if (sum == 0) {
            return true
        } else if (sum < 0) {
            return false
        }

        for (i in c until nums.lastIndex) {
            val find = find(nums, sum - nums[i], i + 1)
            if (find) {
                return true
            }
        }

        return false
    }
}