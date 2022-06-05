package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Shuffle the Array` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(intArrayOf(2, 3, 5, 4, 1, 7), shuffle(intArrayOf(2, 5, 1, 3, 4, 7), 3))
    }


    private fun shuffle(nums: IntArray, n: Int): IntArray {
        val result = IntArray(nums.size)
        var counter = 0
        for (i in 0 until n) {
            result[counter++] = nums[i]
            result[counter++] = nums[i + n]
        }
        return result
    }
}