package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Single Number` {


    @Test
    fun test1() {
        Assertions.assertEquals(3, singleNumber(intArrayOf(1, 1, 2, 2, 3)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(4, singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    }


    private fun singleNumber(nums: IntArray): Int {
        return nums.reduce { acc, i -> acc.xor(i) }
    }
}