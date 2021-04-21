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

        if (triangle.size == 1) {
            return triangle[0][0]
        }

        var cache1 = IntArray(triangle.size)
        cache1[0] = triangle[0][0]

        for (i in 1..triangle.lastIndex) {
            val cache2 = IntArray(triangle.size)
            for (j in triangle[i].indices) {
                if (j == 0) {
                    cache2[j] = triangle[i][j] + cache1[j]
                } else if (j == triangle[i].lastIndex) {
                    cache2[j] = triangle[i][j] + cache1[j - 1]
                } else {
                    cache2[j] = min(triangle[i][j] + cache1[j], triangle[i][j] + cache1[j - 1])
                }
            }
            cache1 = cache2
        }

        return cache1.minOrNull()
    }

}