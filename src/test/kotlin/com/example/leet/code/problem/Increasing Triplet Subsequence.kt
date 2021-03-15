package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Increasing Triplet Subsequence` {
    @Test
    fun test1() {
        Assertions.assertEquals(true, increasingTriplet(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(false, increasingTriplet(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(true, increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(false, increasingTriplet(intArrayOf(5,1,6)))
    }

    private fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) {
            return false
        }

        var a = nums[0]
        var b = Int.MAX_VALUE

        for (i in 1..nums.lastIndex) {
            val c = nums[i]
            when {
                c <= a -> a = c
                c <= b -> b = c
                else -> return true
            }
        }
        return false
    }
}
