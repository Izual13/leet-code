package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Timeout


@Suppress("ClassName")
class `Unique Paths` {

    @Test
    fun test1() {
        Assertions.assertEquals(28, uniquePaths(3, 7))
    }

    @Test
    @Timeout(5)
    fun test2() {
        Assertions.assertEquals(1916797311, uniquePaths(51, 9))
    }

    @Test
    fun test3() {
        Assertions.assertEquals(6, uniquePaths(3, 3))
    }

    private fun uniquePaths(m: Int, n: Int): Int {
        val result: Array<IntArray> = Array(m) { IntArray(n) { 1 } }

        for (i in 1 until m) {
            for (j in 1 until n) {
                result[i][j] = result[i - 1][j] + result[i][j - 1]
            }
        }

        return result[m - 1][n - 1]
    }
}