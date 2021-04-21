package com.example.leet.code.problem

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.min

@Suppress("ClassName")
class Triangle {


    @Test
    fun test1() {
        Assertions.assertEquals(11, minimumTotal(arrayListOf(arrayListOf(2), arrayListOf(3, 4), arrayListOf(6, 5, 7), arrayListOf(4, 1, 8, 3))))
    }

    private fun minimumTotal(triangle: List<List<Int>>): Int? {
        val cache = ArrayList(triangle[triangle.size - 1])

        for (i in triangle.lastIndex - 1 downTo 0) {
            for (j in triangle[i].indices) {
                cache[j] = min(cache[j] + triangle[i][j], cache[j + 1] + triangle[i][j])
            }
        }

        return cache[0]
    }

}