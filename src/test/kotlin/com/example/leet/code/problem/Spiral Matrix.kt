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

        val sizeX = matrix[0].size
        val sizeY = matrix.size


        if (sizeX == 1) {
            for (i in matrix.indices) {
                result.add(matrix[i][0])
            }
            return result
        }

        for (i in 1..(sizeX / 2 + (sizeX % 2))) {
            println("${i} round >>")
            val realI = i - 1

            if (realI >= sizeY - realI) {
                continue
            }

            for (r in realI until sizeX - realI) {
                result.add(matrix[realI][r])
            }

            println(result)

            for (r in realI + 1 until sizeY - realI - 1) {
                result.add(matrix[r][sizeX - realI - 1])
            }

            println(result)

            if (realI == sizeY - realI - 1) {
                continue
            }

            for (r in sizeX - realI - 1 downTo realI + 1) {
                result.add(matrix[sizeY - realI - 1][r])
            }

            println(result)

            for (r in sizeY - realI - 1 downTo realI + 1) {
                result.add(matrix[r][realI])
            }

            println(result)
        }


        return result
    }

}