package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Jump Game` {
    @Test
    fun test1() {
        Assertions.assertEquals(true, canJump(intArrayOf(2, 3, 1, 1, 4)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(false, canJump(intArrayOf(3, 2, 1, 0, 4)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(false, canJump(intArrayOf(0, 2)))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(true, canJump(intArrayOf(0)))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(true, canJump(intArrayOf(2, 0, 0)))
    }

    private fun canJump(nums: IntArray): Boolean {
        for (i in 1..nums.lastIndex) {
            if (nums[i - 1] <= 0) {
                return false
            }

            nums[i] = max(nums[i], nums[i - 1] - 1)
        }
        return true
    }
}
