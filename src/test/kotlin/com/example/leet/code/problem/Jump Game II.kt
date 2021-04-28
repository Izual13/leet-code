package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Jump Game II` {
    @Test
    fun test1() {
        Assertions.assertEquals(2, jump(intArrayOf(2, 3, 1, 1, 4)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(1, jump(intArrayOf(2, 1)))
    }


    private fun jump(nums: IntArray): Int {
        if (nums.size < 2) {
            return 0
        }

        var result = 1

        var maxPosition = nums[0]
        var currentPosition = nums[0]

        for (i in 1 until nums.lastIndex) {

            maxPosition = max(maxPosition, i + nums[i])

            if (currentPosition == i) {
                currentPosition = maxPosition
                result++
            }
        }
        return result
    }
}
