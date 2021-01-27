package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Pascal's Triangle II` {

    @Test
    fun test1() {
        Assertions.assertEquals(arrayListOf(1, 4, 6, 4, 1), getRow(4))
    }

    @Test
    fun test2() {
        Assertions.assertEquals(arrayListOf(1, 1), getRow(1))
    }


    private fun getRow(rowIndex: Int): List<Int> {
        val result = mutableListOf<Int>()


        result.add(1)
        if (rowIndex >= 1) {
            result.add(1)
        }

        for (i in 2..rowIndex) {
            val size = result.size
            for (j in size - 1 downTo 1) {
                result[j] = result[j] + result[j - 1]
            }

            result.add(1)
        }

        return result
    }
}