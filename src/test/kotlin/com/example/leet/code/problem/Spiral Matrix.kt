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
        val matrix = arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(2, 4, 8, 10), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))

        Assertions.assertEquals(listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7), spiralOrder(matrix))
    }


    private fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = ArrayList<Int>()

        val size = matrix.size
        for (i in 1..(size / 2 + (size % 2))) {
            println("${i} round >>")
            val realI = i - 1
            for (r in realI until size - realI) {
                result.add(matrix[realI][r])
            }

            println(result)

            for (r in realI + 1 until size - realI - 1) {
                result.add(matrix[r][size - realI - 1])
            }

            println(result)

            for (r in size - realI - 1 downTo realI + 1) {
                result.add(matrix[size - realI - 1][r])
            }

            println(result)

            for (r in size - realI - 1 downTo realI + 1) {
                result.add(matrix[r][realI])
            }

            println(result)
        }


        return result
    }

}