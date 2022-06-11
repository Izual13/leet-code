package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

@Suppress("ClassName")
class `Find the Duplicate Number` {

    @Test
    fun test1() {
        Assertions.assertEquals(2, findDuplicate(intArrayOf(1, 3, 4, 2, 2)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(3, findDuplicate(intArrayOf(3, 1, 3, 4, 2)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(3, findDuplicate(intArrayOf(3, 1, 3, 4, 2, 3)))
    }


    private fun findDuplicate(nums: IntArray): Int {
        var sum = 0
        var m = 0
        for (i in nums) {
            sum += i
            m = max(m, i)
        }

        val expected = (m + 1) * m / 2
        val remainder = sum - expected

        return remainder / (nums.size - m)
    }
}