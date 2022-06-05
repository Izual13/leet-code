package com.example.leet.code.problem.misc

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Rotate Image` {

    @Test
    fun test1() {
        val matrix = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        rotate(matrix)

//        println("________")
//        println(matrix[0].contentToString())
//        println(matrix[1].contentToString())
//        println(matrix[2].contentToString())
//        println("________")

        Assertions.assertArrayEquals(intArrayOf(7, 4, 1), matrix[0])
        Assertions.assertArrayEquals(intArrayOf(8, 5, 2), matrix[1])
        Assertions.assertArrayEquals(intArrayOf(9, 6, 3), matrix[2])
    }

    @Test
    fun test2() {
        val matrix = arrayOf(intArrayOf(1))
        rotate(matrix)
        Assertions.assertArrayEquals(intArrayOf(1), matrix[0])
    }

    @Test
    fun test3() {
        val matrix = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        rotate(matrix)
        Assertions.assertArrayEquals(intArrayOf(3, 1), matrix[0])
        Assertions.assertArrayEquals(intArrayOf(4, 2), matrix[1])
    }


    @Test
    fun test4() {
        val matrix = arrayOf(intArrayOf(5, 1, 9, 11), intArrayOf(2, 4, 8, 10), intArrayOf(13, 3, 6, 7), intArrayOf(15, 14, 12, 16))
        rotate(matrix)

//        println("________")
//        println(matrix[0].contentToString())
//        println(matrix[1].contentToString())
//        println(matrix[2].contentToString())
//        println(matrix[3].contentToString())
//        println("________")

        Assertions.assertArrayEquals(intArrayOf(15, 13, 2, 5), matrix[0])
        Assertions.assertArrayEquals(intArrayOf(14, 3, 4, 1), matrix[1])
        Assertions.assertArrayEquals(intArrayOf(12, 6, 8, 9), matrix[2])
        Assertions.assertArrayEquals(intArrayOf(16, 7, 10, 11), matrix[3])
    }

    private fun rotate(matrix: Array<IntArray>, level: Int = 0): Unit {

        if (level >= matrix.size / 2) {
            return
        }

        val length = matrix.size - level

        val tmp = IntArray(length)
        var counter = 0
        for (i in level until length) {
            tmp[counter++] = matrix[level][i]
        }

        counter = 0
        for (i in level until length) {
            val tmpV = matrix[i][length - 1]
            matrix[i][length - 1] = tmp[counter]
            tmp[counter++] = tmpV
        }

        counter = 1
        for (i in length - 2 downTo level) {
            val tmpV = matrix[length - 1][i]
            matrix[length - 1][i] = tmp[counter]
            tmp[counter++] = tmpV
        }

        counter = 1
        for (i in length - 2 downTo level) {
            val tmpV = matrix[i][level]
            matrix[i][level] = tmp[counter]
            tmp[counter++] = tmpV
        }

        counter = 1
        for (i in level + 1..length - 2) {
            val tmpV = matrix[level][i]
            matrix[level][i] = tmp[counter]
            tmp[counter++] = tmpV
        }

        rotate(matrix, level + 1)
    }
}
