package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Search a 2D Matrix II` {

    @Test
    fun test1() {
        val matrix = arrayOf(intArrayOf(1, 4, 7, 11, 15), intArrayOf(2, 5, 8, 12, 19), intArrayOf(3, 6, 9, 16, 22), intArrayOf(10, 13, 14, 17, 24), intArrayOf(18, 21, 23, 26, 30))
        Assertions.assertEquals(true, searchMatrix(matrix, 5))
    }

    @Test
    fun test2() {
        val matrix = arrayOf(intArrayOf(1, 4, 7, 11, 15), intArrayOf(2, 5, 8, 12, 19), intArrayOf(3, 6, 9, 16, 22), intArrayOf(10, 13, 14, 17, 24), intArrayOf(18, 21, 23, 26, 30))
        Assertions.assertEquals(false, searchMatrix(matrix, 20))
    }

    @Test
    fun test3() {
        val matrix = arrayOf(intArrayOf(-5))
        Assertions.assertEquals(false, searchMatrix(matrix, -2))
    }


    private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var row = 0
        var col = matrix[0].lastIndex;

        while (row <= matrix.lastIndex && col >= 0) {
            when {
                matrix[row][col] == target -> return true
                matrix[row][col] > target -> col--
                else -> row++
            }
        }

        return false
    }


}