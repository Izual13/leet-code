package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Combination Sum IV` {

    @Test
    fun test1() {
        Assertions.assertEquals(7, combinationSum4(intArrayOf(1, 2, 3), 4))
    }


    private fun combinationSum4(nums: IntArray, target: Int): Int {
        val cache = IntArray(target + 1)
        cache[0] = 1

        for (i in 0..target) {
            for (n in nums) {
                if (i >= n) {
                    cache[i] += cache[i - n]
                }
            }
        }

        return cache[target]
    }
}