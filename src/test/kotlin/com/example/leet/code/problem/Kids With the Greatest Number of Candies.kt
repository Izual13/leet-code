package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Kids With the Greatest Number of Candies` {

    @Test
    fun test1() {
        Assertions.assertArrayEquals(booleanArrayOf(true, true, true, false, true), kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3))
    }


    private fun kidsWithCandies(candies: IntArray, extraCandies: Int): BooleanArray {
        val result = BooleanArray(candies.size)

        val max = candies.maxOrNull()!!

        for (i in candies.indices) {
            if (candies[i] + extraCandies >= max) {
                result[i] = true
            }
        }

        return result
    }
}