package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Missing Number` {


    @Test
    fun test1() {
        Assertions.assertEquals(8, missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(4, missingNumber(intArrayOf(1, 2, 3, 0)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(1, missingNumber(intArrayOf(2, 0)))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(3, missingNumber(intArrayOf(1, 2, 4, 0)))
    }


    private fun missingNumber(nums: IntArray): Int {
        //nums.size * (nums.size + 1) - gauss
        return nums.size * (nums.size + 1) / 2 - nums.sum()
    }
}