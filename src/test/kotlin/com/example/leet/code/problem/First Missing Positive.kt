package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `First Missing Positive` {

    @Test
    fun test1() {
        Assertions.assertEquals(4, firstMissingPositive(intArrayOf(1, 2, 3)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(3, firstMissingPositive(intArrayOf(2, 4, 1)))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(1, firstMissingPositive(intArrayOf(7, 8, 9)))
    }

    @Test
    fun test4() {
        Assertions.assertEquals(4, firstMissingPositive(intArrayOf(0, 1, 2, 3)))
    }

    @Test
    fun test5() {
        Assertions.assertEquals(4, firstMissingPositive(intArrayOf(0, 1, 1, 1, 1, 2, 3)))
    }

    private fun firstMissingPositive(nums: IntArray): Int {
        var result = 1
        val all = nums
            .asSequence()
            .filter { it > 0 }
            .distinct()
            .sorted()
            .all { it == result++ }

        return if (all) result else result - 1
    }
}