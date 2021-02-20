package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Spiral Matrix` {

    @Test
    fun test1() {
        val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))

        Assertions.assertEquals(listOf(1, 2, 3, 6, 9, 8, 7, 4, 5), spiralOrder(matrix))
    }

    @Test
    fun test2() {
        val matrix = arrayOf(intArrayOf(1))

        Assertions.assertEquals(listOf(1), spiralOrder(matrix))
    }

    @Test
    fun test3() {
        val matrix = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))

        Assertions.assertEquals(listOf(1, 2, 4, 3), spiralOrder(matrix))
    }


    @Test
    fun test4() {
        val matrix = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))

        Assertions.assertEquals(listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), spiralOrder(matrix))
    }

    @Test
    fun test5() {
        val matrix = arrayOf(intArrayOf(1, 2, 3, 4))
        Assertions.assertEquals(listOf(1, 2, 3, 4), spiralOrder(matrix))
    }

    @Test
    fun test6() {
        val matrix = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8))
        Assertions.assertEquals(listOf(1, 2, 3, 4, 8, 7, 6, 5), spiralOrder(matrix))
    }

    @Test
    fun test7() {
        val matrix = arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3))
        Assertions.assertEquals(listOf(1, 2, 3), spiralOrder(matrix))
    }


    private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = ArrayList<Int>()

        var x1 = 0
        var x2 = matrix[0].size - 1

        var y1 = 0
        var y2 = matrix.size - 1

        while (x1 <= x2 && y1 <= y2) {
            for (i in x1..x2) result.add(matrix[y1][i])
            for (i in y1 + 1..y2) result.add(matrix[i][x2])

            if (y1 == y2 || x1 == x2) {
                return result
            }

            for (i in x2 - 1 downTo x1 + 1) result.add(matrix[y2][i])
            for (i in y2 downTo y1 + 1) result.add(matrix[i][y1])

            x1++
            y1++
            x2--
            y2--
        }

        return result
    }

}