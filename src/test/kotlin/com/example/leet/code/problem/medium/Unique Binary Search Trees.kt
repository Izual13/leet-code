package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Unique Binary Search Trees` {

    @Test
    fun test1() {
        Assertions.assertEquals(5, numTrees(3))
    }


    private fun numTrees(n: Int): Int {
        if (n == 1) {
            return 1;
        }

        val cache = IntArray(n + 1)
        cache[0] = 1
        cache[1] = 1
        for (i in 2..n) {
            var result = 0
            for (j in 1..i) {
                result += cache[j - 1] * cache[i - j]
            }
            cache[i] = result
        }

        return cache[n]
    }
}