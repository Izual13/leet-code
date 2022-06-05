package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


@Suppress("ClassName")
class `Set Matrix Zeroes` {

    @Test
    fun test1() {
        val matrix = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
        setZeroes(matrix)

        Assertions.assertArrayEquals(intArrayOf(1, 0, 1), matrix[0])
        Assertions.assertArrayEquals(intArrayOf(0, 0, 0), matrix[1])
        Assertions.assertArrayEquals(intArrayOf(1, 0, 1), matrix[2])
    }

    @Test
    fun test2() {
        val matrix = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5)
        )
        setZeroes(matrix)

        Assertions.assertArrayEquals(intArrayOf(0, 0, 0, 0), matrix[0])
        Assertions.assertArrayEquals(intArrayOf(0, 4, 5, 0), matrix[1])
        Assertions.assertArrayEquals(intArrayOf(0, 3, 1, 0), matrix[2])
    }


    @Test
    fun test3() {
        val matrix = arrayOf(
            intArrayOf(1, 0)
        )
        setZeroes(matrix)

        Assertions.assertArrayEquals(intArrayOf(0, 0), matrix[0])
    }

    @Test
    fun test4() {
        val matrix = arrayOf(
            intArrayOf(1),
            intArrayOf(0)
        )
        setZeroes(matrix)

        Assertions.assertArrayEquals(intArrayOf(0), matrix[0])
        Assertions.assertArrayEquals(intArrayOf(0), matrix[1])
    }

    @Test
    fun test5() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 0, 7, 8),
            intArrayOf(0, 10, 11, 12),
            intArrayOf(13, 14, 15, 0)
        )
        setZeroes(matrix)

        Assertions.assertArrayEquals(intArrayOf(0, 0, 3, 0), matrix[0])
        Assertions.assertArrayEquals(intArrayOf(0, 0, 0, 0), matrix[1])
        Assertions.assertArrayEquals(intArrayOf(0, 0, 0, 0), matrix[2])
        Assertions.assertArrayEquals(intArrayOf(0, 0, 0, 0), matrix[3])
    }

    @Test
    fun test6() {
        val matrix = arrayOf(
            intArrayOf(1),
            intArrayOf(0),
            intArrayOf(3)
        )
        setZeroes(matrix)

        Assertions.assertArrayEquals(intArrayOf(0), matrix[0])
        Assertions.assertArrayEquals(intArrayOf(0), matrix[1])
        Assertions.assertArrayEquals(intArrayOf(0), matrix[2])
    }

    private fun setZeroes(matrix: Array<IntArray>): Unit {
        val rows = matrix.lastIndex
        val columns = matrix[0].lastIndex
        val setR = HashSet<Int>()
        val setC = HashSet<Int>()

        for (i in 0..rows) {
            for (j in 0..columns) {
                if (matrix[i][j] == 0) {
                    setR.add(i)
                    setC.add(j)
                }
            }
        }

        for (i in 0..rows) {
            for (j in 0..columns) {
                if (setR.contains(i) || setC.contains(j)) {
                    matrix[i][j] = 0
                }
            }
        }
    }

}