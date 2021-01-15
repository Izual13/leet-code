package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@Suppress("ClassName")
class `Pascal's Triangle` {

    @Test
    fun test1() {
        Assertions.assertEquals(arrayListOf(arrayListOf(1), arrayListOf(1, 1), arrayListOf(1, 2, 1), arrayListOf(1, 3, 3, 1), arrayListOf(1, 4, 6, 4, 1)), generate(4))
    }


    fun generate(numRows: Int): List<List<Int>> {
        val result = arrayListOf<List<Int>>()

        if (numRows > 0) {
            result.add(arrayListOf(1))
        }

        for (i in 1 until numRows) {
            val tmp = arrayListOf<Int>()
            tmp.add(1)
            val last = result.last()
            for (j in 0..last.size - 2) {
                tmp.add(last[j] + last[j + 1])
            }
            tmp.add(1)
            result.add(tmp)
        }

        return result
    }
}