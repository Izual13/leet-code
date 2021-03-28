package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.math.min


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
        val possibleTarget = Arrays.binarySearch(matrix[0], target)
        if (possibleTarget >= 0) {
            return true
        }
        //search in columns
        val maxColumn = min(-possibleTarget - 1, matrix[0].lastIndex)
        var start = 0
        var end = matrix.lastIndex
        var currentColumn = 0

        while (start <= end || maxColumn != currentColumn) {
            if (start > end) {
                start = 0
                end = matrix.lastIndex
                currentColumn++
                continue
            }
            val mid = (start + end) / 2
            if (matrix[mid][currentColumn] == target) {
                return true
            } else if (matrix[mid][currentColumn] > target) {
                end = mid - 1
            } else {
                start = mid + 1
            }
        }


        return false
    }


}