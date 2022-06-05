package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Spiral Matrix II` {

    @Test
    fun test1() {
        val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(8, 9, 4), intArrayOf(7, 6, 5))
        Assertions.assertArrayEquals(matrix, generateMatrix(3))
    }

    @Test
    fun test2() {
        val matrix = arrayOf(intArrayOf(1))
        Assertions.assertArrayEquals(matrix, generateMatrix(1))
    }

    @Test
    fun test3() {
        val matrix = arrayOf(intArrayOf(1, 2), intArrayOf(4, 3))
        Assertions.assertArrayEquals(matrix, generateMatrix(2))
    }


    private fun generateMatrix(n: Int): Array<IntArray> {
        val result: Array<IntArray> = Array(n) { IntArray(n) }

        var x1 = 0
        var x2 = n - 1

        var y1 = 0
        var y2 = n - 1
        var counter = 1

        while (x1 <= x2 && y1 <= y2) {
            for (i in x1..x2) result[y1][i] = counter++
            for (i in y1 + 1..y2) result[i][x2] = counter++
            for (i in x2 - 1 downTo x1 + 1) result[y2][i] = counter++
            for (i in y2 downTo y1 + 1) result[i][y1] = counter++

            x1++
            y1++
            x2--
            y2--
        }

        return result
    }
}