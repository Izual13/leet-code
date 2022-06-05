package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Number of Good Pairs` {


    @Test
    fun test1() {
        Assertions.assertEquals(4, numIdenticalPairs(intArrayOf(1,2,3,1,1,3)))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(0, numIdenticalPairs(intArrayOf(1, 2, 3)))
    }


    private fun numIdenticalPairs(nums: IntArray): Int {
        var result = 0
        val map = HashMap<Int, Int>()

        for (num in nums) {
            val value = map.getOrDefault(num, 0)

            if (value >= 1) {
                result += value
            }

            map[num] = value + 1
        }

        return result
    }
}