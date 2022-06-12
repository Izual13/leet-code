package com.example.leet.code.problem.medium

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Search a 2D Matrix` {

    @Test
    fun test1() {
        Assertions.assertTrue(searchMatrix(arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60)), 3))
    }

    @Test
    fun test2() {
        Assertions.assertFalse(searchMatrix(arrayOf(intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60)), 13))
    }

    @Test
    fun test3() {
        Assertions.assertTrue(searchMatrix(arrayOf(intArrayOf(1)), 1))
    }

    @Test
    fun test4() {
        Assertions.assertTrue(searchMatrix(arrayOf(intArrayOf(1), intArrayOf(3)), 3))
    }


    private fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var row: IntArray = matrix[0]

        var start = 0
        var end = matrix.lastIndex
        while (start <= end) {
            val half = (start + end) / 2
            if (matrix[start].first() <= target && matrix[half].first() > target) {
                end = half - 1
            } else if (matrix[end].last() >= target && matrix[half].last() < target) {
                start = half + 1
            } else {
                row = matrix[half]
                break
            }
        }

        start = 0
        end = row.lastIndex
        while (start <= end) {
            val half = (start + end) / 2

            if (row[half] == target) {
                return true
            } else if (row[start] <= target && row[half] > target) {
                end = half - 1
            } else {
                start = half + 1
            }
        }

        return false
    }
}