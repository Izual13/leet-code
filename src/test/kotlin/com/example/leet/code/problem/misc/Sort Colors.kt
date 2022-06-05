package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Sort Colors` {

    @Test
    fun test1() {
        val nums = intArrayOf(2, 0, 2, 1, 1, 0)
        sortColors(nums)
        Assertions.assertArrayEquals(intArrayOf(0, 0, 1, 1, 2, 2), nums)
    }

    @Test
    fun test2() {
        val nums = intArrayOf(0)
        sortColors(nums)
        Assertions.assertArrayEquals(intArrayOf(0), nums)
    }


    private fun sortColors(nums: IntArray): Unit {
        val array = IntArray(3)
        for (i in nums) {
            array[i]++
        }

        var i = 0
        for (ni in array.indices) {
            for (ci in 1..array[ni]) {
                nums[i++] = ni
            }
        }
    }
}