package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max


@Suppress("ClassName")
class `Longest Increasing Path in a Matrix` {

    @Test
    fun test1() {
        Assertions.assertEquals(4, longestIncreasingPath(arrayOf(intArrayOf(9, 9, 4), intArrayOf(6, 6, 8), intArrayOf(2, 1, 1))))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(1, longestIncreasingPath(arrayOf(intArrayOf(1))))
    }
    @Test
    fun test3() {
        Assertions.assertEquals(6, longestIncreasingPath(arrayOf(intArrayOf(7, 8, 9), intArrayOf(9, 7, 6), intArrayOf(7, 2, 3))))
    }


    private fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        var result = 0
        val cache = Array(matrix.size) { IntArray(matrix[0].size) }
        for (i in matrix.indices) {
            for (j in matrix[0].indices) {
                result = max(result, longestIncreasingPath(matrix, i, j, cache))
            }
        }

        return result
    }

    private val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))

    private fun longestIncreasingPath(
        matrix: Array<IntArray>,
        x: Int,
        y: Int,
        cache: Array<IntArray>
    ): Int {
        val m = matrix.size
        val n = matrix[0].size

        if (cache[x][y] > 0) {
            return cache[x][y]
        }

        var result = 0
        for ((i, j) in directions) {
            val newX = x + i
            val newY = y + j

            if (newX in 0 until m && newY in 0 until n && matrix[x][y] < matrix[newX][newY]) {
                result = max(result, longestIncreasingPath(matrix, newX, newY, cache))
            }
        }

        cache[x][y] = result + 1
        return cache[x][y]
    }
}