package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `House Robber` {
    @Test
    fun test1() {
        Assertions.assertEquals(4, rob(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(12, rob(intArrayOf(2, 7, 9, 3, 1)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(4, rob(intArrayOf(2, 1, 1, 2)))
    }

    @Test
    fun test21() {
        Assertions.assertEquals(4, rob2(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun test22() {
        Assertions.assertEquals(12, rob2(intArrayOf(2, 7, 9, 3, 1)))
    }

    @Test
    fun test23() {
        Assertions.assertEquals(4, rob2(intArrayOf(2, 1, 1, 2)))
    }


    private fun rob(nums: IntArray): Int {
        if (nums.size < 3) {
            return if (nums.size == 1) nums[0] else max(nums[0], nums[1])
        }

        for (i in 2..nums.lastIndex) {
            if (i > 2) {
                nums[i] = max(nums[i] + nums[i - 2], nums[i] + nums[i - 3])
            } else {
                nums[i] = nums[i] + nums[i - 2]
            }
        }

        return max(nums[nums.lastIndex], nums[nums.lastIndex - 1])
    }

    private fun rob2(nums: IntArray): Int {
        var r1 = 0
        var r2 = 0
        var tmp: Int

        for (i in nums) {
            tmp = max(r1 + i, r2)
            r1 = r2
            r2 = tmp
        }

        return r2
    }

}